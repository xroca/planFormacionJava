<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>Uso taglib SQL, prefijo "sql"</h1>
        <p>
        <h2>Uso de una fuente de datos</h2>
        Para acceder a datos lo primero que hemos de hacer es configurar una conexi&oacute;n,<br>
        mediante el DriverManager o referenciando una datasource previamente definida.<br>
        en los archivos web.xml y context.xml (en el caso de Tomcat).<br>
        Aqu&iacute; hemos elegido el segundo m&eacute;todo.<br>
        <sql:setDataSource  dataSource="jdbc/sample"/>
    </p>
    <p>
    <h2>Vamos a realizar una consulta sobre la tabla "CUSTOMER":</h2>
    <strong>SELECT CUSTOMER_ID, NAME FROM CUSTOMER ORDER BY NAME.</strong><br>
    <sql:query maxRows="5" var="clientes" sql="SELECT CUSTOMER_ID, NAME FROM CUSTOMER ORDER BY NAME"/>
    Una vez realizada la consulta, mostramos los resultados empleando el m&eacute;todo "getRowsByIndex" de la interfaz "Result":<br>
    <ul>
        <c:forEach begin="0" var="fila" items="${clientes.rowsByIndex}">
            <li>Identificador ${fila[0]}. Nombre ${fila[1]}</li>
            </c:forEach>
    </ul>
    Obtenemos el mismo resultado empleando el m&eacute;todo "getRows" de la interfaz "Result":<br>
    <ul>
        <c:forEach var="mapa" items="${clientes.rows}">
            <li>Identificador ${mapa['CUSTOMER_ID']}. Nombre ${mapa['NAME']}</li>
            </c:forEach>
    </ul>
</p>
<p>
<h2>Tambi&eacute;n podemos actualizar la base de datos usando opcionalmente transacciones</h2>
Por ejemplo: UPDATE CUSTOMER SET NAME = "ABC" WHERE CUSTOMER_ID = 722<br>
<c:set var="identificador" value="722"/>
<sql:transaction>
    <sql:update var="clientes" sql="UPDATE CUSTOMER SET NAME = 'Big Car Parts' WHERE CUSTOMER_ID = ?">
        <sql:param value="${identificador}"/>
    </sql:update>
</sql:transaction>
Y los resultados:
<sql:query maxRows="5" var="clientes" sql="SELECT CUSTOMER_ID, NAME FROM CUSTOMER ORDER BY NAME"/>
<ul>
    <c:forEach var="mapa" items="${clientes.rows}">
        <li>Identificador ${mapa['CUSTOMER_ID']}. Nombre ${mapa['NAME']}</li>
        </c:forEach>
</ul>            
</p>
</body>
</html>
