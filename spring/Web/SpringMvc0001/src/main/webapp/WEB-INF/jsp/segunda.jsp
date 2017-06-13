<%-- 
    Document   : segunda
    Created on : 18-may-2011, 17:29:30
    Author     : jose maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Segunda p&aacute;gina</title>
    </head>
    <body>
        <h1>P&aacute;gina controlada por Spring</h1>
        <h3>Datos recibidos</h3>
        <p>Se han recibido ${contador} dato(s)</p>
        Nombre: ${persona.nombre}
        <c:if test="${not empty persona.fecha}">
            <br>
            Fecha: <fmt:formatDate value="${persona.fecha}" pattern="dd MMMM, yyyy hh:mm aa"/>
        </c:if>
        <br>
        <a href="index.jsp">Volver</a>
    </body>
</html>
