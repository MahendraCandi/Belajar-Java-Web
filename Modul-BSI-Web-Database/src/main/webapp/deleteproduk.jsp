<%@page import="java.sql.*, com.candi.belajar.model.Produk"%>
<%
	Produk produk=new Produk();
	Connection conn=null;
	Statement st=null;
	ResultSet rs=null;

	Class.forName("com.mysql.jdbc.Driver");
	conn=DriverManager.getConnection("jdbc:mysql://localhost/eprodukshop","root", "admin");
	st=conn.createStatement();
	String id_produk=request.getParameter("id_produk");
	if(id_produk != null){
		rs=st.executeQuery("SELECT * FROM produk WHERE id='" + id_produk + "'");

		if(rs.next()){
			produk.setProdukId(Integer.parseInt(rs.getString("id")));
			produk.setNamaProduk(rs.getString("nama"));
			produk.setHarga(Double.parseDouble(rs.getString("harga")));
			produk.setQty(Integer.parseInt(rs.getString("qty")));
		}
	}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Delete Produk</title>
</head>
<body>
	<form method="POST" action="ProdukSrvCRUD">
		<table border="0" cellspacing="4" cellpadding="2" align="center">
			<caption><h1>Konfirmasi Hapus Data</h1></caption>
			<tbody>
				<tr>
					<td>Id Produk</td>
					<td><input type="text" name="id_produk" size="5" value="<%=produk.getProdukId()%>" readonly></td>
				</tr>
				<tr>
					<td>Nama Produk</td>
					<td><input type="text" name="nama" size="50" value="<%=produk.getNamaProduk()%>" readonly></td>
				</tr>
				<tr>
					<td>Harga@</td>
					<td><input type="text" name="harga" size="10" value="<%=produk.getHarga()%>" readonly></td>
				</tr>
				<tr>
					<td>Qty</td>
					<td><input type="text" name="qty" size="10" value="<%=produk.getQty()%>" readonly></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Delete" name="submit" onclick="return confirm('Are You sure?')">
						<a href="daftarproduk.jsp"><input type="button" value="Kembali" ></a>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>