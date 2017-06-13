<%-- 
    Document   : todobien
    Created on : 17-jul-2012, 18:26:54
    Author     : Chema
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2>El formulario se ha rellenado correctamente</h2>
        <h2>Personas existentes en la base de datos</h2>
        <ul>
            <c:forEach items="${personas}" var="persona">
                <h2>Los datos de la persona son:</h2>  
                <li>
                    Nombre ${persona.nombre}
                </li>
                <li>
                    Apellido ${persona.apellido}
                </li>
            </c:forEach>
        </ul>
        <h1><a href="<c:url value="/"/>">Volver al principio</a></h1>
    </body>
</html>
