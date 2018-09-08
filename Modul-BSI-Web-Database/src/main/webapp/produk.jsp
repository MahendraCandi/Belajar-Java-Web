<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-Type" content="text/html"; charset="UTF-8">
	<title>Data Produk</title>
</head>
<body>
	<form method="POST" action="ProdukSrvCRUD">
		<table border="0" cellspacing="4" cellpadding="3" align="center">
			<caption><h2>Data Produk</h2></caption>
			<tbody>
				<tr>
					<td>Nama Produk</td>
					<td><input type="text" name="nama" size="50"></td>
				</tr>
				<tr>
					<td>Harga@</td>
					<td><input type="text" name="harga" size="10"></td>
				</tr>
				<tr>
					<td>Qty</td>
					<td><input type="text" name="qty" size="10"></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Simpan" name="submit">
						<input type="reset" value="Batal" name="reset">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>