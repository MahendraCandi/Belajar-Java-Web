<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Latihan 4 Proses</title>
</head>
<body>
	<%
		session.setAttribute("login", request.getParameter("username"));
		response.sendRedirect("latihan4index.jsp");
	%>
</body>
</html>