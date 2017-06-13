<%@page contentType="text/html"%>
<html>
    <head><title>JSP Page</title></head>
    <body>
        <div align="center"><font size="5" color="#0000FF">Uso de beans y sus propiedades</font> 
        </div>
        <jsp:useBean id="persona" scope="page" class="beans.Persona" />
        <B>En primer lugar, obtenemos los valores por defecto de las propiedades del bean "Persona":</B>
        <BR>
        El nombre es <jsp:getProperty name="persona"  property="nombre" />
        <BR>
        La edad es <jsp:getProperty name="persona"  property="edad" />
        <BR>
        <B>En segundo lugar, asignamos nuevos valores a ambas propiedades del bean "Persona". Por ejemplo, "Pepe" y 35</B>
        <BR>
        <jsp:setProperty name="persona" property="nombre" value="Pepe" />
        <jsp:setProperty name="persona" property="edad" value="35" />
        <B>Por último, obtenemos los nuevos valores de ambas propiedades del bean "Persona":</B>
        <BR>
        El nuevo nombre es <jsp:getProperty name="persona"  property="nombre" />
        <BR>
        La nueva edad es <jsp:getProperty name="persona"  property="edad" />
    </body>
</html>
