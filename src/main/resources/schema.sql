CREATE TABLE diary (
    d_id INT PRIMARY KEY AUTO_INCREMENT,
    u_id INT,
    d_date DATE,
    title VARCHAR(255),
    content TEXT
);