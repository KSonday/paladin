Create table reset_password_token (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
token VARCHAR(70) NOT NULL,
active TINYINT(1) NOT NULL DEFAULT 1,
user_id INT NOT NULL
);