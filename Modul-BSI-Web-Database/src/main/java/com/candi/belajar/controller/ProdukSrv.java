package com.candi.belajar.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import com.candi.belajar.model.Produk;

public class ProdukSrv extends HttpServlet{
	
		// public ProdukSrv(){
		// 	super();
		// }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
			processRequest(req, res);
		}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		processRequest(req, res);
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out=res.getWriter();

		Produk produk=new Produk();

		produk.setNamaProduk(req.getParameter("nama"));
		produk.setHarga(Double.parseDouble(req.getParameter("harga")));
		produk.setQty(Integer.parseInt(req.getParameter("qty")));

		String URL="jdbc:mysql://localhost/eprodukshop";
		String USERNAME="root";
		String PASSWORD="admin";

		Connection conn=null;
		PreparedStatement query=null;
		int result=0;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
			query=conn.prepareStatement("INSERT INTO produk(nama, harga, qty) VALUES (?,?,?)");
			query.setString(1, produk.getNamaProduk());
			query.setDouble(2, produk.getHarga());
			query.setInt(3, produk.getQty());

			result=query.executeUpdate();

			if(result >= 0){
				out.print("<script language=JavaScript>alert('Data berhasil disimpan');document.location='produk.jsp';</script>");
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	}
}