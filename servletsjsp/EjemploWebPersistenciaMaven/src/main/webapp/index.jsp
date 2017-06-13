<%-- 
    Document   : index
    Created on : 29-abr-2010, 11:52:32
    Author     : jose maria
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Autenticaci&oacute;n de usuarios</h1>
        <form method="post" action="AutenticarServlet">
            <table>
                <tr>
                    <td>
                        Nombre de usuario
                    </td>
                    <td>
                        <input type="text" size="40" name="txtNombre"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        Clave de acceso
                    </td>
                    <td>
                        <input type="text" size="40" name="txtClave"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Enviar"/>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
