<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <meta http-equiv="content-Type" content="text/html;charset=UTF-8" />
    <title>Lazy Load App</title>
    <body>
    <center>
        <h1>Tes Hibernate Lazy Load</h1>
        <a href="index.jsp">Kembali</a>
    </center>
    <br/><br/>
    <div align="center">
        <form method="POST" action="Servlet">
            <table border="1" align="center" cellpadding="5">
                <tr>
                    <th>Id</th>
                    <th>Department</th>
                    <th>Student</th>
                </tr>
                <c:forEach var="x" items="${ListDepartment}">
                    <tr>
                        <td> 
                            <c:out value="${x.idDepartment}"/>
                        </td>
                        <td align="center"> <c:out value="${x.nameDepartment}"/> </td>
                        <td>
                            <a href="/Servlet?id=<c:out value='${x.idDepartment}'/>"> <input type="submit" name="submit" value="Tampil Sertifikat" /> </a>
                            <input type="hidden" name="idSertifikat" value="<c:out value='${x.idDepartment}'/>" />
                            <input type="submit" name="submit" value="Tampil Sertifikat" />
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
    </body>
    
</html>