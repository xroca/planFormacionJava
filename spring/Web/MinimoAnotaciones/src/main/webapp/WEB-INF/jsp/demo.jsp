<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Demo</title>
    </head>
    <body>
        Hoy es
        <strong>
            <fmt:formatDate pattern="dd-MM-YYYY" value="${fecha}"/>
        </strong>
    </body>
</html>
