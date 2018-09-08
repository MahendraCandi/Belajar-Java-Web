package com.mahendracandi.AppBootstrapMaven.model;

public class Pengarang{
    private int id;
    private String nama;
    private Enum kelamin;
    private String alamat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Enum getKelamin() {
        return kelamin;
    }

    public void setKelamin(Enum kelamin) {
        this.kelamin = kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    
}
