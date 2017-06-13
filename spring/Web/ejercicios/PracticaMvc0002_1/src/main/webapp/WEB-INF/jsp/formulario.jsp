<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Usuario</title>
    </head>
    <body>
        <form:form method="post" commandName="usuario">
            <table>
                <tr>
                    <td>Nombre:</td>
                    <td><form:input  path="nombre"/> </td> 
                    <td> <form:errors path="nombre" cssStyle="color: red;"/></td>
                </tr>                    
                <tr> <td colspan=3>   <input type="submit" value="Enviar"> </td>
            </table> 
        </form:form>
    </body>
</html>
