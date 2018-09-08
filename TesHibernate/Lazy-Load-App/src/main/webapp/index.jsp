<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <meta http-equiv="content-Type" content="text/html; charset=UTF-8"/>
    <title>Lazy Load App</title>
    <body>
    <center>
        <h1>Tes Hibernate Lazy Load</h1>
        <a href="">Tampil data</a>
    </center>
        <div align="center">
            <form method="POST" action="Servlet">
                <table cellpadding="5">
                    <tr>
                        <td>Masukan nama department</td>
                        <td>
                            <input type="text" name="nm_department" size="20" maxlength="30"/>
                        </td>
                    </tr>
                    <tr>
                        <td >Masukan nama student :</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            1. <input type="text" name="nm_student"/><br>
                            2. <input type="text" name="nm_student"/><br>
                            3. <input type="text" name="nm_student"/>
                        </td> 
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" name="submit" value="Simpan"/>
                            <input type="submit" name="submit" value="Tampil Department"/>
                        </td>
                    </tr>
                </table>
            </form>
            
        </div>
        
    </body>
</html>
