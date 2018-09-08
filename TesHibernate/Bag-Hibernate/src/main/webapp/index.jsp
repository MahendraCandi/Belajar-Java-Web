<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-Type" content="text/html;charset=UTF-8">
	<title>Bag Hibernate Tes</title>
</head>
<body>
	<center>
		<h1>Tes Bag Hibernate Form Karyawan</h1>
	</center>
	<div align="center">
		<form method="POST" action="Servlet">
			<table border="0" align="center" cellpadding="5">
				<tr>
					<td>
						ID Karyawan
					</td>
					<td>
						<input type="text" name="id" size="10" maxlength="10">
						Max. 10 Kar.
					</td>
				</tr>
				<tr>
					<td>
						Nama
					</td>
					<td>
						<input type="text" name="nama" size="20" maxlength="30">
						Max. 30 Kar.
					</td>
				</tr>
				<tr>
					<td>
						Gaji
					</td>
					<td>
						<input type="text" name="gaji" size="20" maxlength="10">
						
					</td>
				</tr>
				<tr>
					<td colspan="2" align="left">
						Sertifikat
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="sertifikat" value="JavaEE">
						JavaEE Sertifikat
						&nbsp;
						<input type="checkbox" name="sertifikat" value="PHP">
						PHP Sertifikat
						&nbsp;
						<input type="checkbox" name="sertifikat" value="VB.NET">
						VB.NET Sertifikat
					</td>		
				</tr>
				<tr>
					<td>
						<input type="submit" name="submit" value="Simpan">
					</td>
					<td>
						<input type="submit" name="submit" value="Tampil Karyawan">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>