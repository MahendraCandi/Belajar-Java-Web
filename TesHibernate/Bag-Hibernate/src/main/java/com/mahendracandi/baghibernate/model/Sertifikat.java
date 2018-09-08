package com.mahendracandi.baghibernate.model;

import java.io.Serializable;

public class Sertifikat implements Serializable{
	private int idSertifikat;
	private String nama;

	public Sertifikat(){

	}

	public Sertifikat(String nama){
		this.nama=nama;
	}

	public void setIdSertifikat(int id){
		this.idSertifikat=id;
	}

	public int getIdSertifikat(){
		return idSertifikat;
	}

	public void setNama(String nama){
		this.nama=nama;
	}

	public String getNama(){
		return nama;
	}
} 