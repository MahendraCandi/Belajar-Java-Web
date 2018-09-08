package com.mahendracandi.app.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.mahendracandi.app.DAO.LaptopDAO;
import com.mahendracandi.app.model.Laptop;

public class LaptopServlet extends HttpServlet{
	private LaptopDAO laptopDAO;

	public void init(){
		String URL= getServletContext().getInitParameter("URL");
		String USERNAME = getServletContext().getInitParameter("USERNAME");
		String PASSWORD = getServletContext().getInitParameter("PASSWORD");

		// String URL = "jdbc:mysql://localhost/laptopstore?autoReconnect=true&useSSL=false";
		// String USERNAME = "root";
		// String PASSWORD = "admin";
		laptopDAO = new LaptopDAO(URL, USERNAME, PASSWORD);
 	}

 	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
 		doGet(req, res);
 	}

 	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
 		String action=req.getServletPath();

 		try{
 			switch(action){
 				case "/new":
 					showNewForm(req, res);
 					break;
 				case "/insert":
 					insertLaptop(req, res);
 					break;
 				case "/delete":
 					deleteLaptop(req, res);
 					break;
 				case "/edit":
 					showEditForm(req, res);
 					break;
 				case "/update":
 					updateLaptop(req, res);
 					break;
 				default:
 					listLaptop(req, res);
 					break;
 			}
 		}catch(SQLException ex){
 			throw new ServletException(ex);
 		}
 	}

 	private void listLaptop(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException, ServletException{
 		List<Laptop> listLaptop=laptopDAO.listDataLaptop();
 		req.setAttribute("listLaptop", listLaptop);
 		RequestDispatcher dispatcher=req.getRequestDispatcher("LaptopList.jsp");
 		dispatcher.forward(req, res);
 	}

 	private void showNewForm(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
 		RequestDispatcher dispatcher=req.getRequestDispatcher("AddLaptop.jsp");
 		dispatcher.forward(req, res);
 	}

 	private void showEditForm(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
 		int id = Integer.parseInt(req.getParameter("id"));
 		Laptop laptopEksis=laptopDAO.getLaptop(id);
 		RequestDispatcher dispatcher=req.getRequestDispatcher("AddLaptop.jsp");
 		req.setAttribute("laptop", laptopEksis);
 		dispatcher.forward(req, res);
 	}

 	private void insertLaptop(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException{
 		String merk=req.getParameter("merk");
 		String tipe=req.getParameter("tipe");
 		String spesifikasi=req.getParameter("spesifikasi");
 		double harga=Double.parseDouble(req.getParameter("harga"));

 		Laptop newLaptop=new Laptop(merk, tipe, spesifikasi, harga);
 		laptopDAO.addLaptop(newLaptop);
 		res.sendRedirect("list");
 	}

 	private void updateLaptop(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException{
 		int id=Integer.parseInt(req.getParameter("id"));

 		String merk=req.getParameter("merk");
 		String tipe=req.getParameter("tipe");
 		String spesifikasi=req.getParameter("spesifikasi");
 		double harga=Double.parseDouble(req.getParameter("harga"));

 		Laptop laptop=new Laptop(id, merk, tipe, spesifikasi, harga);
 		laptopDAO.updateLaptop(laptop);
 		res.sendRedirect("list");
 	}

 	private void deleteLaptop(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException{
 		int id=Integer.parseInt(req.getParameter("id"));

 		Laptop laptop=new Laptop(id);
 		laptopDAO.deleteLaptop(laptop);
 		res.sendRedirect("list");
 	}
}