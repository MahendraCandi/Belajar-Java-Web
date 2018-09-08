package com.mahendracandi.hibernatemaven.model;
// Generated Mar 21, 2018 9:06:48 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Penerbit generated by hbm2java
 */
@Entity
@Table(name="penerbit"
    ,catalog="dbbuku"
)
public class Penerbit  implements java.io.Serializable {


     private String kdpenerbit;
     private String nmpenerbit;
     private String alamat;
     private String telp;
     
//     tambah tipe data Set<Buku> 
     private Set<Buku> bukus = new HashSet(0);

    public Penerbit() {
    }

	
    public Penerbit(String kdpenerbit, String nmpenerbit) {
        this.kdpenerbit = kdpenerbit;
        this.nmpenerbit = nmpenerbit;
    }
    public Penerbit(String kdpenerbit, String nmpenerbit, String alamat, String telp, Set<Buku> bukus) {
       this.kdpenerbit = kdpenerbit;
       this.nmpenerbit = nmpenerbit;
       this.alamat = alamat;
       this.telp = telp;
       this.bukus = bukus;
    }
   
     @Id 

    
    @Column(name="kdpenerbit", unique=true, nullable=false, length=4)
    public String getKdpenerbit() {
        return this.kdpenerbit;
    }
    
    public void setKdpenerbit(String kdpenerbit) {
        this.kdpenerbit = kdpenerbit;
    }

    
    @Column(name="nmpenerbit", nullable=false, length=30)
    public String getNmpenerbit() {
        return this.nmpenerbit;
    }
    
    public void setNmpenerbit(String nmpenerbit) {
        this.nmpenerbit = nmpenerbit;
    }

    
    @Column(name="alamat", length=100)
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    
    @Column(name="telp", length=15)
    public String getTelp() {
        return this.telp;
    }
    
    public void setTelp(String telp) {
        this.telp = telp;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="penerbit")
//     tambah tipe data Set<Buku>
    public Set<Buku> getBukus() {
        return this.bukus;
    }
    
//     tambah tipe data Set<Buku>
    public void setBukus(Set<Buku> bukus) {
        this.bukus = bukus;
    }




}


