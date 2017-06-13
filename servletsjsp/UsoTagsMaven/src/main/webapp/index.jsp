<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="demo" uri="DemoTags"%>
<%@ taglib prefix="logo" tagdir="/WEB-INF/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tags personalizados</title>
    </head>
    <body>        
        <h1>Ejemplo del uso de <i>tags</i> personalizados</h1>
        <demo:saludo/>
        <br>
        <demo:saludoConAtributos nombre="Uno"/>
        <br>
        <demo:saludoConAtributos nombre="${param['nombre']}"/>
        <br>
        <demo:saludoConTodo nombre="Otro">
            <p><strong>Texto inclu&iacute;do dentro del cuerpo de nuestra etiqueta</strong></p>
        </demo:saludoConTodo>
        <jsp:useBean id="usuario" class="demo.beans.Usuario"/>
        ${demo:buscar(usuario,1)}
        <table>
            <thead>
                <th colspan="2" align="center">Datos del usuario 1</th>
            </thead>
            <tr>
                <td>
                    Identificador
                </td>
                <td>${usuario.id} </td>
            </tr>
            <tr>
                <td>
                    Nombre
                </td>
                <td>${usuario.nombre} </td>
            </tr>
            <tr>
                <td>
                    Clave
                </td>
                <td>${usuario.clave} </td>
            </tr>
        </table>
        <demo:usuarioDaoTag usuario="${usuario}" id="2"/>  
        <logo:demologo cabecera="1" imagen="BuenaNoticia.gif" ancho="370" alto="300" dir="imagenes/">
            Ejemplo de etiqueta definida mediante un <i>tag file</i>
        </logo:demologo>
    </body>
</html>
