<%--  
    Document   : tugas
    Created on : Oct 14, 2017, 7:36:48 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head> 
          <title>Form Pendaftaran</title> 
    </head>
    <body> 
        <h1>Silahkan Lengkapi Form Dengan Benar</h1>
        <form method="get">
        <pre>
        Nama Anda      <input type="text" name="nama" value="" />   <br /><br />  
        Kota Lahir     <input type="text" name="kota" value=""  />   <br /><br />
        Tanggal Lahir  <input type="text" name="tanggal" value=""  />   <br /><br />
        Alamat      <textarea name="alamat" cols="40" rows="4"></textarea> <br /><br />
        Pilih Yang Paling Anda Suka <input type="checkbox" name="hobi" value="olahraga"> Olahraga
                                    <input type="checkbox" name="hobi" value="membaca"> Membaca
                                    <input type="checkbox" name="hobi" value="tidur"> Tidur 
                      <br /><input type="submit" name="submit" value="submit">&nbsp;<input type="reset" name="reset" value="Ulangi">
        </pre>
        </form>
        
        <%
          String nama = request.getParameter("nama");
          String kota = request.getParameter ("kota");
          String tanggal = request.getParameter ("tanggal");
          String alamat = request.getParameter ("alamat");
          String[] hb = request.getParameterValues ("hobi");
          
          String[] tombol=request.getParameterValues("submit");
          //if (request.getParameter("submit")!=""){
          if (tombol != null){
          
              out.println("<h2>Hasil dari input Form</h2>"
                  +"Nama Anda : " + nama 
                  +"<br>Tempat,Tanggal Lahir : " +kota+","+ tanggal 
                  +"<br>Alamat : "+ alamat 
                  +"<br>Hobi Anda : ");
          
          }
         %>
         <%
           if (hb!=null){
          %> 
          
            <ul>
                <%
                  for (int i=0;i<hb.length;i++){
                %>
                <li><%=hb[i]%></li>
                <%
                  }
                %>
            </ul>
                <%
                  }
                %>                    
    </body> 
</html>