package com.mahendracandi.lazyload.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

import com.mahendracandi.lazyload.dao.DAO;
import com.mahendracandi.lazyload.model.Department;
import com.mahendracandi.lazyload.model.Student;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

public class Servlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            processRequest(req, res);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        try{
            processRequest(req, res);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out=res.getWriter();
        String submit=req.getParameter("submit");
        try{
            switch(submit){
                case "Simpan":
                    simpanDepartment(req, res);
                    break;
                case "Tampil Department":
                    tampilDepartment(req, res);
                    break;
                case "Tampil Sertifikat":
                    tampilSertifikat(req, res);
                    break;
                default:
                    break;
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void simpanDepartment(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter out=res.getWriter();
        String nmDept=req.getParameter("nm_department");
        String[] nmStud=req.getParameterValues("nm_student");
        
        ArrayList list=new ArrayList();
        for(int i=0; i<nmStud.length; i++){
            list.add(new Student(nmStud[i]));
        }
        
        Department dept=new Department(nmDept);
        
        try{
            DAO dao=new DAO();
            dept.setStudent(list);
            boolean result=dao.addDepartmen(dept);
            if(result){
                out.println("<script language=javascript>"
                        + "alert('Data berhasil dimasukan!');"
                        + "document.location='index.jsp';"
                        + "</script>");
            }else{
                out.println("<script language=javascript>"
                        + "alert('Data sudah ada!');"
                        + "document.location='index.jsp';"
                        + "</script>");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    private void tampilDepartment(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        DAO dao=new DAO();
        List<Department> list=dao.tampilDepartment();
        req.setAttribute("ListDepartment", list);
        RequestDispatcher dispatcher=req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, res);
    }
    
    private void tampilSertifikat(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter out=res.getWriter();
        String id=req.getParameter("idSertifikat");
        String name=req.getParameter("nameDepartment");
        out.println(id);
        out.println(name);
        out.println("<script language=javascript>"
                + "alert('Boom');"
                + "</script>");
    }
}