package com.candi.belajar.model;

public class Produk{
	private int produkId;
	private String namaProduk;
	private double harga;
	private int qty;

	public int getProdukId(){
		return produkId;
	}

	public void setProdukId(int produkId){
		this.produkId=produkId;
	}

	public String getNamaProduk(){
		return namaProduk;
	}

	public void setNamaProduk(String namaProduk){
		this.namaProduk=namaProduk;
	}

	public double getHarga(){
		return harga;
	}

	public void setHarga(double harga){
		this.harga=harga;
	}

	public int getQty(){
		return qty;
	}

	public void setQty(int qty){
		this.qty=qty;
	}
}