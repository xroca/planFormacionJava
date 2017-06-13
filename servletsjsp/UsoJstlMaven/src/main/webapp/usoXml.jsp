<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Uso taglib XML, prefijo "x"</h1>
        <p>
        <h2>Cargar y analizar el documento xml llamado "personas.xml"</h2>
        Primero, cargamos el documento usando la etiqueta "import", del espacio de nombres "c"<br>
        <c:import url="/personas.xml" var="xml"/>
        Acto seguido, analizamos el documento usando la etiqueta "parse" del espacio de nombres "x"<br>
        <x:parse doc="${xml}" var="listaPersonas"/>
        Al llegar aqu&iacute; sin errores, el documento est&aacute; guardado en la variable "listaPersonas"<br>
        Podemos emplear expresiones "XPath" para manipular la informaci&oacute;n del documento<br>
        Por ejemplo, el nombre de la persona cuyo identificador es 2<br>
        El nombre es
        <x:set var="unaPersona" select="$listaPersonas/personas/persona[@id=2]" />
        <strong><x:out select="$unaPersona/nombre"/></strong>
    </p>
    <p>
    <h2>Tambi&eacute;n podemos usar bucles</h2>
    Por ejemplo, esta es la lista de todas las peronas en el documento xml<br>
    <ul>
        <x:forEach var="persona" select="$listaPersonas/personas/*">
            <li>Nombre <x:out select="$persona/nombre"/>. Identificador  <x:out select="$persona/@id"/></li>
            </x:forEach>
    </ul>
</p>
<p>
    Es posible emplear hojas de estilo Xsl para transformar un documento Xml<br>
    <a href="usoXmlXsl.jsp">Como en este ejemplo</a>
</p>
</body>
</html>
