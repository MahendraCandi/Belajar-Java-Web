<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<title>Aplikasi Jual Laptop</title>
</head>
<body>
	<center>
		<h1>Laptop Management</h1>
		<h2>
			<a href="/new">Tambah Data</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/list">Lihat List</a>
		</h2>
	</center>
	<div align="center">
		<table border="1" cellpadding="5">
			<caption><h2>List Laptop</h2></caption>
			<tr>
				<th>ID</th>
				<th>Merk</th>
				<th>Tipe</th>
				<th>Spesifikasi</th>
				<th>Harga</th>
				<th align="center" colspan="2">Action</th>
			</tr>
			<c:forEach var="laptop" items="${listLaptop}">
				<tr>
					<td><c:out value="${laptop.id}"/></td>
					<td><c:out value="${laptop.merk}"/></td>
					<td><c:out value="${laptop.tipe}"/></td>
					<td><c:out value="${laptop.spesifikasi}"/></td>
					<td><c:out value="${laptop.harga}"/></td>	
					<td>
						<a href="/edit?id=<c:out value='${laptop.id}'/>">Edit</a>
					</td>
					<td>
						<a href="/delete?id=<c:out value='${laptop.id}'/>">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>