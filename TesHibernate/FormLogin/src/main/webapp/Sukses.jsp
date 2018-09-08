<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Sukses</title>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
        <script src="bootstrap/js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <%
            if ((session.getAttribute("username") == null) || (session.getAttribute("username") == "")) {
                response.sendRedirect(application.getContextPath() + "/belum-login.jsp");
            }
        %>
        
        <h1>   Welcome <%=session.getAttribute("username")%></h1>
        <a href="Login?action=logout">Logout</a>
    </body>
</html>

