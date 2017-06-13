<%-- 
    Document   : error
    Created on : 17-jul-2012, 17:21:16
    Author     : Chema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ha ocurrido el siguiente error:</h1>
        <h2>${excepcion}</h2>
        <h2>Lista de errores</h2>
        <ul>
            <li>
                Campo nombre: ${errorNombre}
            </li>
        </ul>
        <h1><a href="cuarta.html">Volver al formulario</a></h1>
    </body>
</html>
