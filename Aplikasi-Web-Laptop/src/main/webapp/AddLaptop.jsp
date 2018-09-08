<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<title>Aplikasi Laptop</title>
</head>
<body>
	<center>
		<h1>Laptop Management</h1>
		<h2>
			<a href="/new">Add New Laptop</a>
			&nbsp;&nbsp;&nbsp;
			<a href="/list">List All Laptop</a>
		</h2>
	</center>
	<div align="center">
		<c:if test="${laptop != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${laptop == null}">
			<form action="insert" method="post">
		</c:if>
		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${laptop != null}">
						Edit Laptop
					</c:if>
					<c:if test="${laptop == null}">
						Add New Laptop
					</c:if>
				</h2>
			</caption>
				<c:if test="${laptop != null}">
					<input type="test" name="id" value="<c:out value='${laptop.id}'/>"/>
				</c:if>
			<tr>
				<th>Merk: </th>
				<td>
					<input type="text" name="merk" maxlength="50" size="45" value="<c:out value='${laptop.merk}'/>" />
				</td>
			</tr>
			<tr>
				<th>Tipe: </th>
				<td>
					<input type="text" name="tipe" maxlength="50" size="45" value="<c:out value='${laptop.tipe}'/>"/>
				</td>
			</tr>
			<tr>
				<th>Spesifikasi: </th>
				<td>
					<input type="text" name="spesifikasi" maxlength="50" size="45" value="<c:out value='${laptop.spesifikasi}'/>"/>
				</td>
			</tr>
			<tr>
				<th>Harga: </th>
				<td>
					<input type="input" name="harga" size="45" value="<c:out value='${laptop.harga}'/>" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" name="Save">
				</td>
			</tr>
		</table>
	</div>
</body>
</html>