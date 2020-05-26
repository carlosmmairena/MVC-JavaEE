<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Esta JSTL se usa para que no tengamos que usar código java en el html -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="bootstrap-4.5.0-dist/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Datos </title>
        
    </head>

    <body>

        <div class="container-fluid">
            <div class="row">
                <!--div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4"> </div-->
                <div class="col-12 col-md-4 mx-auto">

                    <h2> Por favor inicie sesión </h2>
                    <form action="login"  method="POST">
                        <div class="form-group">
                            <label for="ced">Cédula</label>
                            <input type="text" class="form-control" id="ced" name="cedula" aria-describedby="cedSosp">
                            <small id="cedSosp" class="form-text text-muted">
                                La cédula no debe tener guiones y tampoco espacios.
                            </small>
                        </div>
                        <div class="form-group">
                            <label for="pass">Contraseña</label>
                            <input type="password" class="form-control" name="contrasena" id="pass">
                        </div>
                        <button type="submit" class="btn btn-primary"> Iniciar Sesión </button>
                    </form> 

                </div>
                <!--div class="col-12 col-sm-12 col-md-4 col-lg-4 col-xl-4"> </div-->
            </div>
        </div>

        <!-- Recursos de JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="bootstrap-4.5.0-dist/js/bootstrap.min.js"></script>
    </body>
</html>
