<%@page import="java.sql.*, java.io.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
	String URL="jdbc:mysql://localhost/eprodukshop";
	String USERNAME="root";
	String PASSWORD="admin";

	Connection conn=null;
	PreparedStatement query=null;
	ResultSet rs=null;

	try{
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection(URL, USERNAME, PASSWORD);
		query=conn.prepareStatement("SELECT * FROM produk");
		rs=query.executeQuery();
	}catch(Exception err){
		err.printStackTrace();
	}

%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="contentType" content="text/html"; charset="UTF-8">
	<title>Daftar Buku</title>
</head>
<body>
		<table border="1" cellspacing="5" cellpadding="2" align="center" width="50%">
			<caption><h1>Daftar Koleksi Buku</h1></caption>
			<tbody>
				<tr>
					<th>No</th>
					<th>Id</th>
					<th>Nama Produk</th>
					<th align="right">Harga@</th>
					<th align="right">Qty</th>
					<th align="center" colspan="2">Action</th>
				</tr>
				<%
					int i=1;
					while(rs.next()){
				%>
				<tr>
					<td align="center"><%=i%></td>
					<td align="center"><%=rs.getString("id")%></td>
					<td><%=rs.getString("nama")%></td>
					<td><%=rs.getDouble("harga")%></td>
					<td><%=rs.getInt("qty")%></td>
					<td><a href=<%="\"editproduk.jsp?id_produk="  + rs.getString("id") + "\"" %> >Edit</a></td>
					<td><a href=<%="\"deleteproduk.jsp?id_produk=" + rs.getString("id") + "\"" %> >Delete</a></td>
					
				</tr>
				<%
					++i;
					}
				%>
			</tbody>
		</table>
	
</body>
</html>