CREATE TABLE MAHASISWA(
	id INT NOT NULL AUTO_INCREMENT,
	nama VARCHAR(20) default NULL,
	jurusan VARCHAR(20) default NULL,
	ipk DOUBLE default null,
	PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE MATKUL(
	matkulId VARCHAR(10) NOT NULL,
	namaMatkul VARCHAR(30) default NULL,
	sks INT default NULL,
	PRIMARY KEY (matkulId)
)ENGINE=InnoDB;