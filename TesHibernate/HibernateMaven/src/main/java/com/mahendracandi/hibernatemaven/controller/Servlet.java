package com.mahendracandi.hibernatemaven.controller;

import com.mahendracandi.hibernatemaven.dao.DAO;
import com.mahendracandi.hibernatemaven.model.Buku;
import com.mahendracandi.hibernatemaven.model.KelaminEnum;
import com.mahendracandi.hibernatemaven.model.Penerbit;
import com.mahendracandi.hibernatemaven.model.Pengarang;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String submit=request.getParameter("submit");
        try (PrintWriter out = response.getWriter()) {
            switch(submit){
                case "Simpan":
                    simpanBuku(request, response);
                    break;
                default:
                    break;
            }
        }
    }
    
    private void simpanBuku(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException{
        try(PrintWriter out=response.getWriter()){
            out.println("Sukses");
//        kelas pengarang
            String nmPengarang=request.getParameter("nmPengarang");
            String kelamin=KelaminEnum.valueOf(request.getParameter("kelamin")).toString();
            String alamatPengarang=request.getParameter("alamatPengarang");
            Pengarang pengarang=new Pengarang();
            pengarang.setNama(nmPengarang);
            pengarang.setKelamin(kelamin);
            pengarang.setAlamat(alamatPengarang);
            
    //        kelas penerbit
            String kdPenerbit=request.getParameter("kdPenerbit");
            String nmPenerbit=request.getParameter("nmPenerbit");
            String alamatPenerbit=request.getParameter("alamatPenerbit");
            String telp=request.getParameter("telp");
            Penerbit penerbit=new Penerbit();
            penerbit.setKdpenerbit(kdPenerbit);
            penerbit.setNmpenerbit(nmPenerbit);
            penerbit.setAlamat(alamatPenerbit);
            penerbit.setTelp(telp);
            
    //      kelas buku
            String kdBuku=request.getParameter("kdBuku");
            String judul=request.getParameter("judul");
            int halaman=Integer.parseInt(request.getParameter("halaman"));
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            Date tahun=sdf.parse(request.getParameter("tahun"));
            String desk=request.getParameter("deskripsi");
            Buku buku=new Buku();
            buku.setKdbuku(kdBuku);
            buku.setJudul(judul);
            buku.setHalaman(halaman);
            buku.setTahunTerbit(tahun);
            buku.setDeskripsi(desk);
            
            buku.setPengarang(pengarang);
            buku.setPenerbit(penerbit);
            
            pengarang.getBukus().add(buku);
            penerbit.getBukus().add(buku);
            
            DAO dao=new DAO();
            dao.tambahBuku(pengarang, penerbit, buku);
            
        }catch(Exception ex){
        
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
    }// </editor-fold>

}
