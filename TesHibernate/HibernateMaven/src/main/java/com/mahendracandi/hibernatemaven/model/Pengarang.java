package com.mahendracandi.hibernatemaven.model;
// Generated Mar 21, 2018 9:06:48 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pengarang generated by hbm2java
 */
@Entity
@Table(name="pengarang"
    ,catalog="dbbuku"
)
public class Pengarang  implements java.io.Serializable {


     private Integer id;
     private String nama;
     private String kelamin;
     private String alamat;
     
//     tambah tipe data Set<Buku>
     private Set<Buku> bukus = new HashSet(0);

    public Pengarang() {
    }

	
    public Pengarang(String nama) {
        this.nama = nama;
    }
    public Pengarang(String nama, String kelamin, String alamat, Set<Buku> bukus) {
       this.nama = nama;
       this.kelamin = kelamin;
       this.alamat = alamat;
       this.bukus = bukus;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="nama", nullable=false, length=50)
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }

    
    @Column(name="kelamin", length=6)
    public String getKelamin() {
        return this.kelamin;
    }
    
    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    
    @Column(name="alamat", length=100)
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="pengarang")
//     tambah tipe data Set<Buku> 
    public Set<Buku> getBukus() {
        return this.bukus;
    }

//     tambah tipe data Set<Buku>    
    public void setBukus(Set<Buku> bukus) {
        this.bukus = bukus;
    }




}


