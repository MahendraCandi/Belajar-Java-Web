<%@page contentType="text/html" pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html>
<head>
	<title>HTML Request Parameter</title>
</head>
<body>
	<h3>Silahkan pilih hobi anda</h3>
	<form method="get">
		<input type="text" name="nama_depan" placeholder="Masukan nama depan"/>
		<input type="text" name="nama_belakang" placeholder="Masukan nama belakang"/>
		<input type="submit" value="Submit">
		<input type="reset" value="Batalkan">
	</form>
	<%
		String nama1=request.getParameter("nama_depan");
		String nama2=request.getParameter("nama_belakang");
		if(request.getParameter("Submit") != ""){
			out.println("<h2>Nama Anda adalah " + nama1 + " nama belakang " + nama2 +"</h2>");
		} 
	%>

</body>
</html>