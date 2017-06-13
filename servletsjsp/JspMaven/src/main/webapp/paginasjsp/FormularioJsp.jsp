<%@page contentType="text/html"%>
<jsp:useBean id="persona" scope="page" class="beans.Persona" />
<jsp:setProperty name="persona" property="*" />

<html>
    <head><title>JSP Page</title></head>
    <body>
        <div align="center"><font size="5" color="#0000FF">Uso de formularios en páginas JSP</font> 
        </div>
        <form method="post">
            <B>Nombre:</B><input type="text" name="nombre" size="25">
            <br>
            <B>Edad:</B><input type="text" name="edad" size="5">
            <br>
            <input type="submit" value="Enviar">
            <input type="reset" value="Limpiar">
        </form>
        <%
            if (request.getParameter("nombre") != null && request.getParameter("edad") != null) {
        %>
        <%@ include file="FormularioRespuesta.jsp" %>
        <%
            }
        %>
    </body>
</html>
