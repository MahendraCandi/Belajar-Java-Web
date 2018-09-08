create table buku(
    kdbuku VARCHAR(4) NOT NULL PRIMARY KEY,
    judul VARCHAR(50) NOT NULL,
    halaman INT NOT NULL,
    tahun_terbit DATE NOT NULL,
    deskripsi VARCHAR(255) NOT NULL,
    idpengarang INT NOT NULL,
    kdpenerbit VARCHAR(4) NOT NULL,
        CONSTRAINT FK_PengarangBuku FOREIGN KEY (idpengarang)
        REFERENCES pengarang(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,
        CONSTRAINT FK_PenerbitBuku FOREIGN KEY (kdpenerbit)
        REFERENCES penerbit(kdpenerbit)
        ON DELETE RESTRICT
        ON UPDATE CASCADE
)Engine=InnoDb;
