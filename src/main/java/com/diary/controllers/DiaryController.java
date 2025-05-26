package com.diary.controllers; // あなたのパッケージ名に合わせる

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.diary.service.DiaryAnalysisService;
import com.diary.service.DiaryService;
import com.diary.vo.DiaryAnalysisVo;
import com.diary.vo.DiaryVo;

@Controller
public class DiaryController {

	@Autowired
	DiaryService diaryService;
	@Autowired
	DiaryAnalysisService analysisService;
	
    @GetMapping({"/", "", "diary"})
    public String showLandingPage() {
        return "landing";
    }

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "dashboard";
    }
    
    //달력에 일기 쓴 날 표시하는 메서드
    @GetMapping("/api/diary/month")
    @ResponseBody
    public List<String> getDiaryDatesByMonth(
        @RequestParam int userId,
        @RequestParam int year,
        @RequestParam int month
    ) {
    	List<String> list =diaryService.findDiaryDatesByMonth(userId, year, month); 
    	System.out.println(list);
        return list;
    }


    @GetMapping("/write")
    public String showWriteDiaryPage(Model model) {
        LocalDate today = LocalDate.now();
        model.addAttribute("currentDate", today.format(DateTimeFormatter.ISO_LOCAL_DATE));
        return "writeDiary";
    }

    @PostMapping("/write")
    public String postDiary(
    		@RequestParam("diaryDate") String diaryDateStr,
            @RequestParam("title") String title,
            @RequestParam("content") String content,
            RedirectAttributes redirectAttributes) {

    	DiaryVo diary = new DiaryVo();
        diary.setUId(1); // 실제 로그인 유저 ID로 대체해야 함
        
        // String → java.sql.Date 변환 (DB 저장용)
        java.sql.Date diaryDate = java.sql.Date.valueOf(diaryDateStr);
        diary.setDate(diaryDate);
        
        diary.setTitle(title);
        diary.setContent(content);

        diaryService.writeDiary(diary);
        DiaryAnalysisVo DAVo = analysisService.analyzeDiary(diary.getTitle(), diary.getContent(), diary.getDId());

        redirectAttributes.addFlashAttribute("diaryAnalysis", DAVo);
        redirectAttributes.addFlashAttribute("message", "日記が正常に投稿されました！");

        return "redirect:/dashboard";
    }

    @GetMapping("/diary/{date}")
    public String getDiaryByDate(@PathVariable String date, Model model) {
        DiaryVo diary = diaryService.findDiaryByDate(1, date);
        model.addAttribute("diary", diary);
        
        int dId = diary.getDId();
        System.out.println(dId);
        
        DiaryAnalysisVo DAVo = analysisService.getDA(1,dId);
        model.addAttribute("diaryAnalysis", DAVo);
        System.out.println(DAVo);
        System.out.println(diary);
        return "diaryDetail";
    }
}