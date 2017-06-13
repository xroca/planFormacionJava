<%@page contentType="text/html"%>
<%@page import="beans.Empleado"%>
<html>
    <head><title>JSP Page</title></head>
    <body>
        <div align="center"><font size="5" color="#0000FF">Respuesta a la consulta de empleados</font> 
        </div>
        <%! Empleado[] todos = null; %>
        <%
            todos = Empleado.listaEmpleadosOrdenadosPorNombre(request.getParameter("nombre"));
            if(todos.length == 0)
                out.println("No hay empleados que tengan el nombre " + request.getParameter("nombre") + "<BR>");
            else for( int i = 0; i < todos.length; i++){
                out.println(todos[i].getApellido() + "," + todos[i].getNombre() + ".");
        %>
        <BR>
        <%
            }
        %>
        <a href="FormularioEmpleados.jsp">Volver a la p&aacute;gina de consulta</a> 
    </body>
</html>
