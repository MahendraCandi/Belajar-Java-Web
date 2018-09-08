<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="context-Type" content="text/ html;charset=UTF-8">
	<title>Tes Bag Hibernate</title>
</head>
<body>
	<center>
		<h1>Tes Bag Hibernate List Data Karyawan</h1>
	</center>
	<div align="center">
		<form method="POST" action="Servlet">
			<table align="center" cellpadding="10" border="1">
				<tr>
					<th>Id Karyawan</th>
					<th>Nama</th>
					<th>Gaji</th>
					<th>Sertifikat</th>
				</tr>
				<c:forEach var="karyawan" items="${listKaryawan}">
					<tr>
						<td><c:out value="${karyawan.idKaryawan}"/></td>
						<td><c:out value="${karyawan.namaKaryawan}"/></td>
						<td><c:out value="${karyawan.gaji}"/></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
</body>
</html>