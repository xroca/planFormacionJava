<%@page contentType="text/html"%>
<%@page import="java.util.*"%>
<html>
    <head><title>Uso de expresiones</title></head>
    <body>
        <div align="center"><font size="5" color="#0000FF">Uso de expresiones JSP</font> 
        </div>
        <B>La fecha actual es:</B> <%= new Date() %>
        <BR>
        <B>El ordenador remoto es:</B> <%= request.getRemoteHost() %>
    </body>
</html>
