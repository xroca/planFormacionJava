<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>        
        <h1>Uso taglib CORE, prefijo "c"</h1>
        <c:if test="${param.saludar}">        
            <p>Valores recogidos de la request como par&aacute;metros:!Hola <strong>${param.nombre}!</strong></p>
        </c:if>
        <p>
        <h2>Creaci&oacute;n y uso de variables<br></h2>
            <jsp:useBean id="fecha" class="java.util.Date"/>
            <c:set var="unaVariable" value="${fecha}"/>
        Valor de la variable llamada unaVariable: <c:out value="${unaVariable}"/><br>
        <c:remove var="unaVariable"/>
        Acabamos de borrar la variable usando la etiqueta "remove"<br>
        Valor de la variable llamada unaVariable: <c:out value="${unaVariable}"/>
    </p>
    <p>
    <h2>Etiquetas condicionales</h2>
    <c:if test="${empty unaVariable}">
        La variable llamada "unaVariable" est&aacute; vac&iacute;a o no existe<br>
    </c:if>
    Le damos ahora el valor "a"
    <c:set var="unaVariable" value="a"/>
    y lo comprobamos mediante la etiqueta "choose"<br>
    <c:choose>
        <c:when test="${unaVariable == 'a'}">
            La variable vale ${unaVariable}<br>
        </c:when>
        <c:otherwise>
            La variable tiene un valor distinto de "a"<br>
        </c:otherwise>
    </c:choose>            
</p>
<p>
<h2>Etiquetas de control de flujo</h2>
<jsp:useBean id="lista" class="beans.ListaPersonas"/>
<c:forEach items="${lista.personas}" var="persona">
    El nombre de la persona es ${persona.nombre}<br>
</c:forEach>            
</p>
<p>
<h2>Reescritura de URLs</h2>
<c:url var="unaUrl" value="/index.jsp">
    <c:param name="uno" value="dos"/>
</c:url>
<a href="${unaUrl}">Pinche aqu&iacute;</a>
</p>
<p>
<h2>Gesti&oacute;n local de excepciones</h2>            
<c:catch var="error">
    <%
                    int i = 0;

                    if (i < 5) {
                        throw new NullPointerException();
                    }%>
</c:catch>
<c:if test="${error != null}">
    Ha ocurrido un error: ${error.message}<br>
</c:if>
<c:if test="${error == null}">
    No ha ocurrido ning&uacute;n error                
</c:if>
</p>
</body>
</html>
