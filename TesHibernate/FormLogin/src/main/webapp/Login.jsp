<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.css">
        <script src="bootstrap/js/jquery-3.3.1.min.js"></script>
        <script src="bootstrap/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container " style="min-height: 100%; min-height: 100vh; display: flex; align-items: center;">
            <div class="text-center col-md-4 col-md-offset-4" style="width: 100%">
                <h1>Silahkan Login</h1>
                <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">Login</button>
            </div>
        </div>

        <%-- start modal --%>
        <div id="myModal" class="modal fade" role="dialog">
            <div class="modal-dialog">
                <!-- konten modal -->
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">&times;</button>
                        <h4 class="modal-tittle">Login</h4>
                    </div>
                    <form action="LoginServlet" method="POST">
                        <div class="modal-body">
                            <div class="form-group">
                                <label>Username or email</label>
                                <input type="text" class="form-control" name="username">
                            </div>
                            <div class="form-group">
                                <label>Password</label>
                                <input type="password" class="form-control" name="password">
                            </div>
                        </div>
                        <div class="modal-footer">
                            <input type="reset" class="btn btn-default" name="reset" value="Reset">
                            <input type="submit" class="btn btn-primary" name="submit" value="Login">
                        </div>
                    </form>
                </div>
                <!-- akhir konten model -->
            </div>
        </div>
        <%-- end modal --%>
    </body>
</html>

