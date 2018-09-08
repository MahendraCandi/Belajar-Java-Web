<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-Type" content="text/html"; charset="UTF-8">
	<title>Hibernate Tes</title>
</head>
<body>
	<center>
		<H1>Form Mahasiswa</H1>
		<a href="index_matkul.jsp">Buka Form Mata Kuliah</a>
	</center>
	<form method="POST" action="MahasiswaServlet">
		<div align="center">
			<table align="center" cellpadding="10">
				<tr>
					<td>Nama</td>
					<td>
						<input type="text" name="nama" size="20" maxlength="20"> 
						(Max. 20 karakter)
					</td>
				</tr>
				<tr>
					<td>Jurusan</td>
					<td>
						<input type="text" name="jurusan" size="20" maxlength="20"> 
						(Max. 20 karakter)
					</td>
				</tr>
				<tr>
					<td>IPK</td>
					<td>
						<input type="text" name="ipk" size="10" maxlength="5" >
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Simpan" name="submit" ></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>