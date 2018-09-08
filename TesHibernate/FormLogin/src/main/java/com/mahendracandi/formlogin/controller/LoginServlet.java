package com.mahendracandi.formlogin.controller;

import com.mahendracandi.formlogin.dao.AdminDAO;
import com.mahendracandi.formlogin.model.Admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String submit=request.getParameter("submit");
            if(submit.equals("Login")){
                out.println(submit);
                String user=request.getParameter("username");
                String password=request.getParameter("password");
                if(password == null || password.equals("")){
                    response.sendRedirect("Error.jsp");
                }else{
                    AdminDAO dao=new AdminDAO();
                    List<Admin> list=new ArrayList<>();
                    list=dao.loginAdmin(user, password);
                    if(list.isEmpty()){
                        response.sendRedirect("Gagal.jsp");
                    }else{
                        HttpSession session=request.getSession(true);
                        Iterator itr=list.iterator();
                        while(itr.hasNext()){
                            Object[] obj=(Object[]) itr.next();
                            session.setAttribute("id", obj[0]);
                            session.setAttribute("username", obj[1]);
                            session.setAttribute("password", obj[2]);
                            session.setAttribute("email", obj[3]);
                            session.setAttribute("regdate", obj[4]);
                            response.sendRedirect("index.jsp");
                        }
                    }
                }
            }else if(submit.equals("logout")){
                HttpSession session=request.getSession();
                session.invalidate();
                response.sendRedirect("Login.jsp");
            }
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
