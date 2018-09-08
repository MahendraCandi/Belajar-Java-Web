package com.candi.app;
import java.sql.*;
//import java.sql.Connection;

public class MahasiswaDAO{
	private Connection conn;
	private String dbDriver = "com.mysql.jdbc.Driver";
	private String dbUrl = "jdbc:mysql://localhost/uts?autoReconnect=true&useSSL=false";
	private String dbUsername = "root";
	private String dbPassword = "admin";

	public void connect(){
		try{
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}catch(Exception err){
			err.printStackTrace();	
		}
	}

	public void disconnect(){
		try{
			if(conn != null){
				conn.close();
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	}

	public void simpan(Mahasiswa m){
		try{
			connect();
			String sql = "insert into mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, alamat) values (?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, m.getNpm());
			ps.setString(2, m.getNama());
			ps.setString(3, m.getTempatLahir());
			ps.setDate(4, new java.sql.Date(m.getTanggalLahir().getTime()));
			ps.setString(5, m.getJenisKelamin().toString());
			ps.setString(6, m.getAlamat());

			ps.executeUpdate();

			disconnect();
		}catch(Exception err){
			err.printStackTrace();
		}
	}
}
