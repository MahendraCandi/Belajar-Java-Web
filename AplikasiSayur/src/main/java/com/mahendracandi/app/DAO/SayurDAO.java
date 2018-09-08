package com.mahendracandi.app.DAO;


import java.sql.*;
import com.mahendracandi.app.model.Sayur;

public class SayurDAO{
	private Connection conn;
	private String DRIVER="com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://localhost/dbsayur";
	private String USERNAME="root";
	private String PASSWORD="admin";

	public void connect()throws SQLException{
		try{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}catch(Exception err){
			err.printStackTrace();
		}
	}

	public void disconnect()throws SQLException{
		try{
			if(conn != null){
				conn.close();
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	}

	public void simpan(Sayur s)throws SQLException{
		connect();
		String sql="INSERT INTO sayur (kdSayur, nmSayur, hrgSayur, stok) VALUES(?,?,?,?)";

		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, s.getKodeSayur());
		ps.setString(2, s.getNamaSayur());
		ps.setDouble(3, s.getHargaSayur());
		ps.setInt(4, s.getStok()); 

		ps.executeUpdate();

		disconnect();
	}

	public void edit(Sayur s)throws SQLException{
		connect();
		String sql="UPDATE sayur SET nmSayur=?, hrgSayur=?, stok=?";

		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, s.getNamaSayur());
		ps.setDouble(2, s.getHargaSayur());
		ps.setInt(3, s.getStok());

		ps.executeUpdate();

		disconnect();
	}

	public void hapus(Sayur s)throws SQLException{
		connect();
		String sql="DELETE FROM sayur WHERE kdSayur=?";

		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, s.getKodeSayur());

		ps.executeUpdate();

		disconnect();
	}
}