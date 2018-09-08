package com.mahendra.candi.model;

import java.io.Serializable;

public class MataKuliah implements Serializable{

	private String matkulId;
	private String namaMatkul;
	private int sks;

	public MataKuliah(){}

	public MataKuliah(String matkulId, String namaMatkul, int sks){
		this.matkulId=matkulId;
		this.namaMatkul=namaMatkul;
		this.sks=sks;
	}

	public void setMatkulId(String matkulId){
		this.matkulId=matkulId;
	}

	public String getMatkulId(){
		return this.matkulId;
	}

	public void setNamaMatkul(String namaMatkul){
		this.namaMatkul=namaMatkul;
	}

	public String getNamaMatkul(){
		return this.namaMatkul;
	}

	public void setSks(int sks){
		this.sks=sks;
	}

	public int getSks(){
		return this.sks;
	}
}