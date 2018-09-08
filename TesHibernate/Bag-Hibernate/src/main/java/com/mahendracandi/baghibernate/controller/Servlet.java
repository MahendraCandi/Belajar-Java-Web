package com.mahendracandi.baghibernate.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Iterator;

import com.mahendracandi.baghibernate.model.*;
import com.mahendracandi.baghibernate.dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import org.hibernate.exception.ConstraintViolationException;

public class Servlet extends HttpServlet{
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        try{
			processRequest(req, res);
		}catch(SQLException err){
			err.printStackTrace();
		}catch(ClassNotFoundException err){
			err.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        try{
			processRequest(req, res);
		}catch(SQLException err){
                        err.printStackTrace();
		}catch(ClassNotFoundException err){
			err.printStackTrace();
		}
	}

	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException, SQLException, ClassNotFoundException{
		res.setContentType("text/html;charset=UTF-8");
		String submit = req.getParameter("submit");
		try{
			switch(submit){
				case "Simpan":
					simpanKaryawan(req, res);
					break;
				case "Hapus":
					//hapusKaryawan(req, res);
					break;
				case "Edit":
					//hapusKaryawan(req, res);
					break;
				case "Tampil Karyawan":
					tampilKaryawan(req, res);
					break;
				default:
					break;
			}
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	

	private void simpanKaryawan(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        PrintWriter out=res.getWriter();
        String id=req.getParameter("id");
		String nama=req.getParameter("nama");
		double gaji=Double.parseDouble(req.getParameter("gaji"));
		String[] sert=req.getParameterValues("sertifikat");
                
		ArrayList list=new ArrayList();
        for(int i=0; i < sert.length; i++ ){
            list.add(new Sertifikat(sert[i]));
            Iterator itr=list.iterator();
		}
        Karyawan karyawan=new Karyawan(id, nama, gaji);
		try{
			daoImp dao=new daoImp();
            karyawan.setSertifikat(list);
			boolean result=dao.addKaryawan(karyawan);
			if(result==true){
				out.println("<script language=javascript>"
                        + "alert('Data berhasil dimasukan!');"
                        + "document.location='index.jsp';"
                        + "</script>");
			}else{
				out.println("<script language=javascript>"
                        + "alert('Proses Gagal! Data ini telah eksis!');"
                        + "document.location='index.jsp';"
                        + "</script>");
			}
		}catch(Exception ex){
            ex.printStackTrace();
        }
	}

	private void tampilKaryawan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		daoImp impl=new daoImp();
        String id = req.getParameter("id");
        List<Karyawan> listKaryawan = impl.showKaryawan();
		req.setAttribute("listKaryawan", listKaryawan);
		RequestDispatcher dispatcher = req.getRequestDispatcher("ListKaryawan.jsp");
		dispatcher.forward(req, res); 
	}

	private void deleteKaryawan(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		

	}
}