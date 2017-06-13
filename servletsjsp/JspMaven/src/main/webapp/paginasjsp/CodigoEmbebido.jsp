<%@page contentType="text/html"%>
<html>
    <head><title>JSP Page</title></head>
    <body>

        <div align="center"><font size="5" color="#0000FF">Uso de código Java embebido en páginas JSP</font> 
        </div>
        <% 
        for(int i = 0; i < 5; i++)
            out.println("Número: " + i + "<BR>");
        %>
        <% if (Math.random() < 0.5) { %>
        Ha salido un número menor que 0.5
        <% } else { %>
        Ha salido un número mayor o igual que 0.5
        <% } %>
    </body>
</html>
