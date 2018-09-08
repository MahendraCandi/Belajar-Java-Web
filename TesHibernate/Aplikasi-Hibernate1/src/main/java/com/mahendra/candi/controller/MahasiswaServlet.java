package com.mahendra.candi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mahendra.candi.model.Mahasiswa;
import com.mahendra.candi.service.MahasiswaService;

public class MahasiswaServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		String nama=req.getParameter("nama");
		String jurusan=req.getParameter("jurusan");
		double ipk=Double.parseDouble(req.getParameter("ipk"));

		Mahasiswa mahasiswa=new Mahasiswa(nama, jurusan, ipk);
		try{

			MahasiswaService mahasiswaService=new MahasiswaService();
			boolean result=mahasiswaService.addMahasiswa(mahasiswa);

			if(result){
				out.println("<script language=javascript>"
					+ "alert('Data berhasil dimasukan!');"
					+ "document.location='index.jsp';"
					+ "</script>");
			}else{
				out.println("<script language=javascript>"
					+ "alert('Data gagal dimasukan! Silahkan coba kembali!')"
					+ "document.location='index.jsp';"
					+ "</script>");
			}
		}finally{
			out.close();
		}
	}
}