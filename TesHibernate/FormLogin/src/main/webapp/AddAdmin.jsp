<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.util.Date"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
<html>
    <head>
        <title>Add Admin</title>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.css"/>
        <script src="bootstrap/js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <!--variabel-->
        <fmt:setLocale value="id_ID" />
        <c:set var="tgl" value="<%=new Date()%>"/>
        <fmt:formatDate var="x" pattern="dd / MMMM / yyyy" value="${tgl}"/>
        <!-- navigasi bar responsive -->
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Responsive Collapse</a>
                </div>
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#"><span class="glyphicon glyphicon-user"></span></a></li>
                        <li><a href="#"><span class="glyphicon glyphicon-log-in"></span></a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="jumbotron">
            <center>
                <h1>Form Login</h1>
                <p>
                    Masukan Admin Baru
                </p>
            </center>
        </div>
        
        <div class="col-md-4 col-md-offset-2">
            <form action="AdminServlet" method="POST">
                <div class="form-group">
                    <label for="username">Masukan Username:</label>
                    <input type="text" class="form-control" name="username">
                </div>
                <div class="form-group">
                    <label for="email">Masukan email:</label>
                    <input type="email" class="form-control" name="email">
                </div>
                <div class="form-group">
                    <label for="password">Masukan password:</label>
                    <input type="password" class="form-control" name="password">
                </div>
                <div class="form-group">
                    <label for="regdate">Tanggal Registrasi:</label>
                    <input type="text" class="form-control " name="regdate" value="${x}" >
                </div>
                <input type="submit" class="btn btn-primary" name="submit" value="Simpan">
            </form>
        </div>
        <div class="col-md-4">
            
        </div>
    </body>
</html>