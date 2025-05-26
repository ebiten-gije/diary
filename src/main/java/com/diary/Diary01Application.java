package com.diary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.diary.mapper")
public class Diary01Application {

	public static void main(String[] args) {
		SpringApplication.run(Diary01Application.class, args);
	}

}
