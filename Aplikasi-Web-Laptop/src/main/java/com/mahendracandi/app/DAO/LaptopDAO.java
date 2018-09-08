package com.mahendracandi.app.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mahendracandi.app.model.Laptop;

public class LaptopDAO{

	private String URL;
	private String USERNAME;
	private String PASSWORD;
	private Connection conn;

	public LaptopDAO(String URL, String USERNAME, String PASSWORD){
		this.URL=URL;
		this.USERNAME=USERNAME;
		this.PASSWORD=PASSWORD;
	}

	protected void connect() throws SQLException{
		try{
			if(conn == null || conn.isClosed()){
				Class.forName("com.mysql.jdbc.Driver");
			}
		}catch(ClassNotFoundException err){
			throw new SQLException(err);
		}
		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	protected void disconnect() throws SQLException{
		if(conn != null && !conn.isClosed()){
			conn.close();
		}
	}

	public boolean addLaptop(Laptop laptop) throws SQLException{
		String sql="INSERT INTO laptop (merk, tipe, spesifikasi, harga) VALUES (?,?,?,?)";
		connect();

		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, laptop.getMerk());
		st.setString(2, laptop.getTipe());
		st.setString(3, laptop.getSpesifikasi());
		st.setDouble(4, laptop.getHarga());

		boolean addRow=st.executeUpdate() > 0;
		st.close();
		disconnect();
		return addRow;
	}

	public List<Laptop> listDataLaptop() throws SQLException{
		List<Laptop> list=new ArrayList<>();

		String sql="SELECT * FROM laptop";

		connect();

		Statement st=conn.createStatement();
		ResultSet rs=st.executeQuery(sql);

		while(rs.next()){
			int id=rs.getInt("id");
			String merk=rs.getString("merk");
			String tipe=rs.getString("tipe");
			String spesifikasi=rs.getString("spesifikasi");
			double harga=rs.getDouble("harga");

			Laptop laptop=new Laptop(id, merk, tipe, spesifikasi, harga);
			list.add(laptop);
		}

		rs.close();
		st.close();

		disconnect();

		return list;
	}

	public boolean deleteLaptop(Laptop laptop) throws SQLException{
		String sql="DELETE FROM laptop WHERE id=?";

		connect();

		PreparedStatement st=conn.prepareStatement(sql);
		st.setInt(1, laptop.getId());

		boolean rowDeleted=st.executeUpdate() > 0;
		st.close();
		disconnect();
		return rowDeleted;
	}

	public boolean updateLaptop(Laptop laptop) throws SQLException{
		String sql="UPDATE laptop SET merk=?, tipe=?, spesifikasi=?, harga=? WHERE id=?";

		connect();
		PreparedStatement st=conn.prepareStatement(sql);
		st.setString(1, laptop.getMerk());
		st.setString(2, laptop.getTipe());
		st.setString(3, laptop.getSpesifikasi());
		st.setDouble(4, laptop.getHarga());
		st.setInt(5, laptop.getId());

		boolean rowUpdated=st.executeUpdate() > 0;
		st.close();
		disconnect();
		return rowUpdated;
	}

	public Laptop getLaptop(int id) throws SQLException{
		Laptop laptop=null;
		String sql="SELECT * FROM laptop WHERE id=?";

		connect();

		PreparedStatement st=conn.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs=st.executeQuery();

		if(rs.next()){
			String merk=rs.getString("merk");
			String tipe=rs.getString("tipe");
			String spesifikasi=rs.getString("spesifikasi");
			double harga=rs.getDouble("harga");

			laptop=new Laptop(id, merk, tipe, spesifikasi, harga);
		}

		rs.close();
		st.close();

		return laptop;
	}
}