<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Tugas 1 Modul BSI</title>
</head>
<body>
	<h3>Silahkan lengkapi form dengan benar</h3>
	<form method="get">
		<table>
			<tr>
				<td>
					Nama Anda
				</td>
				<td colspan="10">
					<input type="text" name="nama" placeholder="Masukan nama Anda" />
				</td>
			</tr>
			<tr>
				<td>
					Kota Lahir
				</td>
				<td colspan="10">
					<input type="text" name="kota" placeholder="Masukan kota lahir Anda" />
				</td>
			</tr>
			<tr>
				<td>
					Tanggal Lahir
				</td>
				<td colspan="10">
					<input type="text" name="tanggal_lahir" placeholder="Masukan format YYYY-MM-dd"/>
				</td>
			</tr>
			<tr>
				<td>
					Alamat
				</td>
				<td colspan="10">
					<textarea name="alamat" rows="5" cols="20" placeholder="Masukan alamat"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					Pilih hobi Anda
				</td>
				<td colspan="10">
					<input type="checkbox" name="hobi" value="Bergadang">Bergadang
					<input type="checkbox" name="hobi" value="Nongkrong">Nongkrong
					<input type="checkbox" name="hobi" value="Bergitar">Bergitar
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" name="submit_tes" value="Submit">
				</td>
				<td>
					<input type="reset" value="Reset">
				</td>
			</tr>
		</table>
	</form>
	<%
		String nama=request.getParameter("nama");
		String kota=request.getParameter("kota");
		String tgl=request.getParameter("tanggal_lahir");
		String alamat=request.getParameter("alamat");
		String[] hobi=request.getParameterValues("hobi");
		String tombol=request.getParameter("submit_tes");

		if(request.getParameter("submit_tes") != null){
	%>
			
				<h3>Hasil dari input form</h3>
				<table>
					<tr>
						<td>
							Nama Anda
						</td>
						<td>
							<%= nama %>
						</td>
					</tr>
					<tr>
						<td>
							Tempat/tanggal lahir
						</td>
						<td>
							<%=kota%>, <%= tgl %>
						</td>
					</tr>
					<tr>
						<td>
							Alamat
						</td>
						<td>
							<%= alamat %>
						</td>
					</tr>
					<tr>
						<td>
							Hobi Anda
						</td>
						<td>
							<ul>
								<%
									if(hobi == null){
								%>
										No hobi selected.
								<%		
									}else{
										for(int i=0;i<hobi.length;i++){
								%>
											<li><%= hobi[i] %></li>
								<%
										}
									}
								%>
								
							</ul>
						</td>
					</tr>
				</table>
			
			
	<%
		}
	%>
</body>
</html>