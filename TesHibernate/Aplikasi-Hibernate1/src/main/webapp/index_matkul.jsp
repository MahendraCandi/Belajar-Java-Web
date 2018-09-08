<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-Type" content="text/html; charset="UTF-8">
	<title>Tes Hibernate</title>
</head>
<body>
	<center>
		<h1>Form Mata Kuliah</h1>
		<a href="index.jsp">Kembali</a>
	</center>
	<form method="POST" action="MataKuliahServlet">
		<div align="center">
			<table align="center" cellpadding="10">
				<tr>
					<td>Kode Matkul</td>
					<td>
						<input type="input" name="matkulId" size="20">
					</td>
				</tr>
				<tr>
					<td>Nama Matkul</td>
					<td>
						<input type="input" name="namaMatkul" size="20" maxlength="30"> 
					</td>
				</tr>
				<tr>
					<td>Bobot sks</td>
					<td>
						<select name="sks">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" name="submit" value="Submit">
					</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>