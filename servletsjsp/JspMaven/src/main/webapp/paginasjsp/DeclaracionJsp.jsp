<%@page contentType="text/html"%>
<html>
    <head><title>JSP Page</title></head>
    <body>

        <div align="center"><font size="5" color="#0000FF">Uso de declaraciones JSP</font> 
        </div>
        <%! private int unAtributo = 0; %>
        Aquí podríamos usar cualesquiera órdenes HTML.
        <BR>
        Y ahora manipulamos la variable declarada anteriormente:
        <BR>
        El valor del atributo más uno es:
        <%= ++unAtributo %>
    </body>
</html>
