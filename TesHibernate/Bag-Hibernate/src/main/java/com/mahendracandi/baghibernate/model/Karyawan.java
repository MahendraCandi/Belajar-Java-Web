package com.mahendracandi.baghibernate.model;


import java.io.Serializable;
import java.util.*;

public class Karyawan implements Serializable{

	private String idKaryawan;
	private String namaKaryawan;
	private double gaji;
	private Collection sertifikat;
	
	public Karyawan(){

	}

	public Karyawan(String idKaryawan, String namaKaryawan, double gaji){
		this.idKaryawan=idKaryawan;
		this.namaKaryawan=namaKaryawan;
		this.gaji=gaji;
        this.sertifikat=sertifikat;
	}

	public void setIdKaryawan(String idKaryawan){
		this.idKaryawan=idKaryawan;
	}

	public String getIdKaryawan(){
		return idKaryawan;
	}

	public void setNamaKaryawan(String namaKaryawan){
		this.namaKaryawan=namaKaryawan;
	}

	public String getNamaKaryawan(){
		return namaKaryawan;
	}

	public void setGaji(double gaji){
		this.gaji=gaji;
	}

	public double getGaji(){
		return gaji;
	}

	public void setSertifikat(Collection sertifikat){
		this.sertifikat=sertifikat;
	}

	public Collection getSertifikat(){
		return sertifikat;
	}
}