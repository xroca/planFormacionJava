<%-- 
    Document   : formulario
    Created on : 15-jun-2017, 9:16:58
    Author     : xrocal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Añadir persona</h1>
        
        
        <form action="afegirServlet" method="post">
            
            <input type="text" name="nombre" id="nombre" value="">
            
            
            <input type="submit" value="Enviar"/>
            
        </form>    
        
        
    </body>
</html>
