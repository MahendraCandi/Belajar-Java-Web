package com.mahendracandi.app.model;

public class Sayur{

	String kodeSayur;
	String namaSayur;
	double hargaSayur;
	int stok;

	public Sayur(String kodeSayur, String namaSayur, String hargaSayur, String stok){
		this.kodeSayur=kodeSayur;
		this.namaSayur=namaSayur;
		this.hargaSayur=hargaSayur;
		this.stok=stok;
	}

	public void setKodeSayur(String kodeSayur){
		this.kodeSayur=kodeSayur;
	}

	public String getKodeSayur(){
		return kodeSayur;
	}

	public void setNamaSayur(String namaSayur){
		this.namaSayur=namaSayur;
	}

	public String getNamaSayur(){
		return namaSayur;
	}

	public void setHargaSayur(double hargaSayur){
		this.hargaSayur=hargaSayur;
	}

	public double getHargaSayur(){
		return hargaSayur;
	}

	public void setStok(int stok){
		this.stok=stok;
	}

	public int getStok(){
		return stok;
	}
}