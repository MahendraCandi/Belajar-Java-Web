<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<body>
	<%
		session.setAttribute("login", null);
		session.invalidate();
		response.sendRedirect("latihan4index.jsp");
	%>
</body>
</html>