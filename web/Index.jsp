<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Esta JSTL se usa para que no tengamos que usar código java en el html -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
              crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Datos </title>
    </head>

    <body>

        <div class="container-fluid">
            <div class="row row-cols-3">
                <div class="col"> -- </div>
                <div class="col">


                    <h2> Por favor inicie sesión </h2>
                    <form action="MVC-JavaEE/login"  method="POST">
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
                <div class="col"> -- </div>
            </div>
        </div>

    </body>
</html>
