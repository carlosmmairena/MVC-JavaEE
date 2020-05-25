<!-- Esta JSTL se usa para que no tengamos que usar código java en el html -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
              integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
              crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Categorías</title>

    </head>
    <body>

        <h2> Categorías Registradas </h2>
        <c:forEach  items="${categTodas}" var="categori">

            <p> ${categori} </p>
            <p> --------------------- </p>

        </c:forEach>

        <h2> Usuario que ha iniciado sesión </h2>
        <c:forEach  items="${datosUser}" var="user">

            <p> ${user} </p>
            <p> --------------------- </p>
        </c:forEach>



    </body>
</html>
