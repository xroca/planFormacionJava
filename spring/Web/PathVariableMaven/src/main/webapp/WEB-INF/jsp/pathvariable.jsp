<%-- 
    Document   : pathvariable
    Created on : 17-jul-2012, 18:39:34
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
        <h2>Los par&aacute;metros recibidos son:</h2>
        <ul>
            <li>
                N&uacute;mero de cliente ${idCliente}
            </li>
            <li>
                N&uacute;mero de factura ${idFactura}
            </li>
        </ul>
        <h1><a href="<c:url value="/"/>">Volver al principio</a></h1>
    </body>
</html>
