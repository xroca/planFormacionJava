<%@page contentType="text/html"%>
<html>
    <head><title>JSP Page</title></head>
    <body>

        <div align="center"><font size="5" color="#0000FF">Uso de declaraciones JSP</font> 
        </div>
        <%! private int unAtributo = 0; %>
        Aqu� podr�amos usar cualesquiera �rdenes HTML.
        <BR>
        Y ahora manipulamos la variable declarada anteriormente:
        <BR>
        El valor del atributo m�s uno es:
        <%= ++unAtributo %>
    </body>
</html>
