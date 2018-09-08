package com.mahendracandi.app.model;

public class User{

	String kodeUser;
	String namaUser;
	String password;
	String hakAkses;

	public void setKodeUser(String kodeUser){
		this.kodeUser=kodeUser;
	}

	public String getKodeUser(){
		return kodeUser;
	}

	public void setNamaUser(String namaUser){
		this.namaUser=namaUser;
	}

	public String getNamaUser(){
		return namaUser;
	}

	public void setPassword(String password){
		this.password=password;
	}

	public String getPassword(){
		return password;
	}

	public void setHakAkses(String hakAkses){
		this.hakAkses=hakAkses;
	}

	public String getHakAkses(){
		return hakAkses;
	}
}