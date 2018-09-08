<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="webjars/bootstrap/4.0.0-2/css/bootstrap.css"/>
        <link rel="stylesheet" href="webjars/c/1.7.1/css/bootstrap-datepicker.css"/>
        <link rel="stylesheet" href="webjars/font-awesome/5.0.6/web-fonts-with-css/css/fontawesome-all.css"/>
        <link rel="stylesheet" href="style.css">
        <title>JSP Page</title>
    </head>
    <body>
        <!--jumbotron-->
        <div class="jumbotron text-center">
            <img src="img/foto.jpg" class="rounded-circle"/>
            <h1>Aplikasi Web</h1>
            <p>Maven Hibernate Bootstrap</p>
        </div>
        <!--akhir jumbotron-->
        
        <!--form buku-->
        <section class="formBuku" id="formBuku">
            <id class="container">
                <div class="row">
                    <div class="col-sm-12">
                        <h2 class="text-center">Form Buku</h2>
                        <hr>
                    </div>
                </div>
                <form action="MyServlet" method="POST">
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Kode Buku</label>
                            <input type="text" class="form-control form-control-sm" name="kdBuku">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Judul Buku</label>
                            <input type="text" class="form-control form-control-sm" name="judul">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Jumlah Halaman</label>
                            <input type="text" class="form-control form-control-sm" name="halaman">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Tahun Terbit</label>
                            <div class="input-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-calendar-alt fa-1x"></i></span>
                                </div>
                                <input type="text" class="form-control" name="tahun" placeholder="yyyy-mm-dd">
                            </div>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Deskripsi Buku</label>
                            <input type="text" class="form-control form-control-sm" name="deskripsi">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Nama Pengarang</label>
                            <input type="text" class="form-control form-control-sm" name="nmPengarang">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Jenis Kelamin</label>
                            <input type="text" class="form-control form-control-sm" name="kelamin">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Alamat</label>
                            <input type="text" class="form-control form-control-sm" name="alamatPengarang">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Kode Penerbit</label>
                            <input type="text" class="form-control form-control-sm" name="kdPenerbit">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Nama Penerbit</label>
                            <input type="text" class="form-control form-control-sm" name="nmPenerbit">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>Alamat</label>
                            <input type="text" class="form-control form-control-sm" name="alamatPenerbit">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <label>No. Telpon</label>
                            <input type="text" class="form-control form-control-sm" name="telp">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-6 offset-md-3">
                            <button type="submit" name="submit" value="Simpan" class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form>
            </id>
        </section>
        <!--akhir form buku-->
        
    <script src="webjars/jquery/3.3.1-1/jquery.js"></script>
    <script src="webjars/bootstrap/4.0.0-2/js/bootstrap.js"></script>
    <script src="webjars/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
    <script src="webjars/font-awesome/5.0.6/svg-with-js/js/fontawesome.js"></script>
    </body>
</html>
