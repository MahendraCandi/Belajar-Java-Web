/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahendracandi.formlogin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import com.mahendracandi.formlogin.dao.AdminDAO;
import com.mahendracandi.formlogin.model.Admin;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String submit=request.getParameter("submit");
        out.println(submit);
        try {
            switch(submit){
                case "Simpan":
                    simpanAdmin(request, response);
                    break;
                case "Data":
                    lihatAdmin(request, response);
                    break;
            }
        } finally {
            out.close();
        }
    }
    
    public void simpanAdmin(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        PrintWriter out=response.getWriter();
        try{
            Admin admin=new Admin();
            AdminDAO dao=new AdminDAO();
            admin.setUsername(request.getParameter("username"));
            admin.setEmail(request.getParameter("email"));
            admin.setPassword(request.getParameter("password"));
            admin.setRegdate(new Date());
            dao.tambahAdmin(admin);
            out.print("Sukses");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void lihatAdmin(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        PrintWriter out=response.getWriter();
        try{
            AdminDAO dao=new AdminDAO();
            List<Admin> list=new ArrayList<>();
            list=dao.dataAdmin();
            request.setAttribute("listAdmin", list);
            RequestDispatcher dispatcher=request.getRequestDispatcher("AddAdmin.jsp");
            dispatcher.forward(request, response);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
