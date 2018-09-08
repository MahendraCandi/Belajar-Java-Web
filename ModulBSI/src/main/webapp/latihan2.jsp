<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HTML Request Parameter</title>
    </head>
    <body>
        <h3>Silahkan pilih hobi Anda:</h3>
        <form method="get">
            <input type="checkbox" name="hobi" value="Olahraga">Olahraga
            <input type="checkbox" name="hobi" value="Membaca">Membaca
            <input type="checkbox" name="hobi" value="Travelling">Travelling
            <br>
            <input type="submit" value="Submit">
        </form>
        <%
        	String[] authors=request.getParameterValues("hobi");
        	if(authors != null){
        %>
        		<h3>Hobi Anda adalah<h3>
        		<ul>
        			<%
        				for(int i=0; i < authors.length; i++){
        			%>
        					<li><%= authors[i]%></li>
        			<%
        				}
        			%>
        		</ul>
        		<a href="<%= request.getRequestURI() %>">BACK</a>
        <%
        	}
        %>

    </body>
</html>
