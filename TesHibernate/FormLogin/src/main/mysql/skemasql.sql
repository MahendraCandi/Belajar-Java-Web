create table admin(
    id int(5) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    email VARCHAR(25) NOT NULL,
    regdate DATE NOT NULL
)ENGINE=INNODB;
