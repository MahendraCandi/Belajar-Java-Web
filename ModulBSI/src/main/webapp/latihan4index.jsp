<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Latihan 4 JSP Session</title>
</head>
<body>
	<h1>SELAMAT DATANG</h1>
	<%
		String username=(String) session.getAttribute("login");
		if(username != null){
			out.println("<h2><i>"+username+"</i></h2>");
			out.println("<a href=latihan4logout.jsp>Logout</a>");
		}else{
			out.println("Silahkan login terlebih dahulu!");
			out.println("<a href=latihan4login.jsp>Login</a>");
		}
	%>
</body>
</html>