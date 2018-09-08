package com.mahendracandi.app.model;

public class DetailTransaksi{

	private int id;
	private String noTrans;
	private String kodeSayur;
	private double harga;
	private int qty;
	private double subtotal;

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setNoTrans(String noTrans){
		this.noTrans=noTrans;
	}

	public String getNoTrans(){
		return noTrans;
	}

	public void setKodeSayur(String kodeSayur){
		this.kodeSayur=kodeSayur;
	}

	public String getKodeSayur(){
		return kodeSayur;
	}

	public void serHarga(double harga){
		this.harga=harga;
	}

	public double getHarga(){
		return harga;
	}

	public void setQty(int qty){
		this.qty=qty;
	}

	public int getqty(){
		return qty;
	}

	public void setSubtotal(double subtotal){
		this.subtotal=subtotal;
	}

	public double getSubtotal(){
		return subtotal;
	}
}