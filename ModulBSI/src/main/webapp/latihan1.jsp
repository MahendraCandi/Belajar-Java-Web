<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>First JSP</title>
</head>
<body>
	<%
	double num=Math.random();
	if(num > 0.95){
	%>	
		<h2>Selamat Anda beruntung</h2><p>(<%= num %>)</p>
	<%
	}else{
	%>
		<h2>Silahkan coba lagi...!</h2><p>(<%= num %>)</p>
	<%
	}
	%>
	<a href="">KLIK</a>
</body>
</html>