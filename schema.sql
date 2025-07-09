CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    cutoff INT
);

CREATE TABLE college (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100),
    course VARCHAR(100),
    cutoff INT
);

CREATE TABLE feedback (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    college_id INT,
    comment TEXT,
    rating INT,
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (college_id) REFERENCES college(id)
);
