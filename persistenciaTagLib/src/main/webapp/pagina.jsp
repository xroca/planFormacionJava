<%-- 
    Document   : pagina
    Created on : 14-jun-2017, 16:56:39
    Author     : xrocal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Listado de personas</h1>
        

        <c:forEach items="${lista}" var="persona">
            El nombre de la persona es ${persona.nombre}<br>
        </c:forEach>


    </body>
</html>
