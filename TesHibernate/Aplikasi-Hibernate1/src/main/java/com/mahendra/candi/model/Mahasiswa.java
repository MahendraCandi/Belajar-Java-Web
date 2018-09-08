package com.mahendra.candi.model;

public class Mahasiswa{
	private int id;
	private String nama;
	private String jurusan;
	private double ipk;

	public Mahasiswa(){}

	public Mahasiswa(String nama, String jurusan, double ipk){
		this.nama=nama;
		this.jurusan=jurusan;
		this.ipk=ipk;
	}

	public void setId(int id){
		this.id=id;
	}

	public int getId(){
		return id;
	}

	public void setNama(String nama){
		this.nama=nama;
	}

	public String getNama(){
		return nama;
	}

	public void setJurusan(String jurusan){
		this.jurusan=jurusan;
	}

	public String getJurusan(){
		return jurusan;
	}

	public void setIpk(double ipk){
		this.ipk=ipk;
	}

	public double getIpk(){
		return ipk;
	}

}