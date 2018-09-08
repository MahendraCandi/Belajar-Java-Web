create table produk(
	id INT PRIMARY KEY AUTO_INCREMENT,
	nama VARCHAR(50) NOT NULL,
	harga DOUBLE NOT NULL,
	qty INT NOT NULL
) Engine=InnoDb;