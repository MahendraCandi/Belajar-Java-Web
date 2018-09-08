<%-- 
    Document   : index
    Created on : Jan 28, 2018, 8:46:44 AM
    Author     : candi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hibernate App</title>
    </head>
    <body>
    <center>
        <h1>Hello World!</h1>
    </center>
    <div align="center">
        <form method="POST" action="NewServlet">
            <table>
                <tr>
                    <td>Kode Baju</td>
                    <td>
                        <input type="text" name="kode" size="10" maxlength="10"/>
                    </td>
                </tr>
                <tr>
                    <td>Merk Baju</td>
                    <td>
                        <input type="text" name="merk" size="30" maxlength="30"/>
                    </td>
                </tr>
                <tr>
                    <td>Ukuran</td>
                    <td>
                        <select name="ukur">
                            <option value="s">S</option>
                            <option value="m">M</option>
                            <option value="l">L</option>
                            <option value="xl">XL</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" name="submit" value="Submit"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
    </body>
</html>
