<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Esta JSTL se usa para que no tengamos que usar código java en el html -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Datos </title>
    </head>
    
    <body>
        
        <h2> Datos del usuario </h2>
        <!-- Ahora podemos leer los datos almacenados en el objeto request con una etiqueta -->
        <p> <c:out value="${nomb}" default="nada"></c:out> </p>
        <p> <c:out value="${cedula}" default="nada"></c:out> </p>
        <p> <c:out value="${passw}" default="Sin datos"></c:out> </p>
        
    </body>
</html>
