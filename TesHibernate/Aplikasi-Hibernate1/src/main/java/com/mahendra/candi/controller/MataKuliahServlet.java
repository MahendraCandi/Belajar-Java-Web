package com.mahendra.candi.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mahendra.candi.model.MataKuliah;
import com.mahendra.candi.service.MataKuliahService;

public class MataKuliahServlet extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{

	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out=res.getWriter();
		String matkulId=req.getParameter("matkulId");
		String namaMatkul=req.getParameter("namaMatkul");
		int sks=Integer.parseInt(req.getParameter("sks"));

		MataKuliah matkul=new MataKuliah(matkulId, namaMatkul, sks);
		
                try{
                    MataKuliahService matkulService=new MataKuliahService();
                    boolean result=matkulService.addMataKuliah(matkul);
                if(result){
                    out.println("<script language=javascript>"
                            + "alert('Data berhasil dimasukan!');"
                            + "document.location='index_matkul.jsp';"
                            + "</script>");
                }else{
                    out.println("<script language=javascript>"
                            + "alert('Data tidak berhasil dimasukan! Coba kembali!');"
                            + "document.location='index_matkul.jsp';"
                            + "</script>");
                    }
                }finally{
                    out.close();
                }
                
        }
}