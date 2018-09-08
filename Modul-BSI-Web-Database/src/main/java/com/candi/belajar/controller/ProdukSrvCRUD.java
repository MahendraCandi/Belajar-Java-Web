package com.candi.belajar.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import com.candi.belajar.model.Produk;
import java.sql.*;

public class ProdukSrvCRUD extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			processRequest(req, res);
		}catch(SQLException err){
			err.printStackTrace();
		}catch(ClassNotFoundException err){
			err.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		try{
			processRequest(req, res);
		}catch(SQLException err){
			err.printStackTrace();
		}catch(ClassNotFoundException err){
			err.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException, ClassNotFoundException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out=res.getWriter();
		
		Produk produk=new Produk();

		String URL="jdbc:mysql://localhost/eprodukshop";
		String USERNAME="root";
		String PASSWORD="admin";

		Connection conn=null;
		PreparedStatement ps=null;
		int result=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);

			String submit=req.getParameter("submit");
			if(submit != null){
				produk.setNamaProduk(req.getParameter("nama"));
				produk.setHarga(Double.parseDouble(req.getParameter("harga")));
				produk.setQty(Integer.parseInt(req.getParameter("qty")));

				switch(submit){
					case "Simpan":
					ps=conn.prepareStatement("INSERT INTO produk (nama, harga, qty) VALUES (?,?,?)");
					ps.setString(1, produk.getNamaProduk());
					ps.setDouble(2, produk.getHarga());
					ps.setInt(3, produk.getQty());

					result=ps.executeUpdate();
					if(result > 0){
						out.println("<script language=JavaScript>alert('Data telah ditambahkan');"
							+ "document.location='produk.jsp';"
							+ "</script>");
					}
					break;

					case "Edit":
					produk.setProdukId(Integer.parseInt(req.getParameter("id_produk")));
					ps=conn.prepareStatement("UPDATE produk SET nama=?, harga=?, qty=? WHERE id=?");
					ps.setString(1, produk.getNamaProduk());
					ps.setDouble(2, produk.getHarga());
					ps.setInt(3, produk.getQty());
					ps.setInt(4, produk.getProdukId());

					result=ps.executeUpdate();
					if(result > 0){
						out.println("<script language=JavaScript>"
							+ "alert('Data telah di edit!');"
							+ "document.location='daftarproduk.jsp';"
							+ "</script>");
					}
					break;

					case "Delete":
					produk.setProdukId(Integer.parseInt(req.getParameter("id_produk")));
					ps=conn.prepareStatement("DELETE FROM produk WHERE id=?");
					ps.setInt(1, produk.getProdukId());

					result=ps.executeUpdate();
					if(result > 0){
						out.println("<script language=JavaScript>"
							+ "alert('Data telah di hapus!');"
							+ "document.location='daftarproduk.jsp';"
							+ "</script>");
					}
					break;
				default:
					break;
				}
			}

		}catch(Exception err){
			err.printStackTrace();
		}
	}
}