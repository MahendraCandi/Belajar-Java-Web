package com.mahendracandi.app.model;

import java.util.Date;

public class Transaksi{
	String noTrans;
	Date tanggal;
	double total;

	public void setNoTrans(String noTrans){
		this.noTrans=noTrans;
	}

	public String getNoTrans(){
		return noTrans;
	}

	public void setTanggal(Date tanggal){
		this.tanggal=tanggal;
	}

	public Date getTanggal(){
		return tanggal;
	}

	public void setTotal(double total){
		this.total=total;
	}

	public double getTotal(){
		return total;
	}
}