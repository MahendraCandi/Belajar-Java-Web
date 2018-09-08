create table pengarang(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nama VARCHAR(50) NOT NULL,
    kelamin ENUM('Pria', 'Wanita'),
    alamat VARCHAR(100)
)Engine=InnoDb;

