package com.mahendracandi.app.model;

public class Laptop{
	private int id;
	private String merk;
	private String tipe;
	private String spesifikasi;
	private double harga;

	public Laptop(int id){
		this.id=id;
	}

	public Laptop(int id, String merk, String tipe, String spesifikasi, double harga){
		this.id=id;
		this.merk=merk;
		this.tipe=tipe;
		this.spesifikasi=spesifikasi;
		this.harga=harga;
	}

	public Laptop(String merk, String tipe, String spesifikasi, double harga){
		this.merk=merk;
		this.tipe=tipe;
		this.spesifikasi=spesifikasi;
		this.harga=harga;
	}

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setMerk(String merk){
		this.merk=merk;
	}

	public String getMerk(){
		return merk;
	}

	public void setTipe(String tipe){
		this.tipe=tipe;
	}

	public String getTipe(){
		return tipe;
	}

	public void setSpesifikasi(String spesifikasi){
		this.spesifikasi=spesifikasi;
	}

	public String getSpesifikasi(){
		return spesifikasi;
	}

	public void setHarga(double harga){
		this.harga=harga;
	}

	public double getHarga(){
		return harga;
	}
}