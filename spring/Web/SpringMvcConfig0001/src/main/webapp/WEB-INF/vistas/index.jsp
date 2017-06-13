
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring MVC Configuraci&oacute;n</title>
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.min.js"></script>
        <script>
            $(document).ready(function() {
                $("#accordion").accordion();
            });
        </script>
    </head>
    <body style="font-size:62.5%">
        <div id="mostrar" style="margin-bottom: 10px">
            <h2>Ejemplo SpringMvcConfig0001</h2>
        </div>
        <div id="accordion">
            <h3><a href="#">Secci&oacute;n 1</a></h3>
            <div>
                <h2 style="text-align: center">Aplicaci&oacute;n JEE 7.0 con Spring Web MVC 4.X</h2>
            </div>
            <h3><a href="#">Secci&oacute;n 2</a></h3>
            <div>
                <p>Estamos usando la versi&oacute;n 3.X de las APIs de las servlets: el web.xml no es obligatorio</p>
                <p>La configuraci&oacute;n de Spring no usa XML</p>
            </div>
            <h3><a href="#">Secci&oacute;n 3</a></h3>
            <div>
                <p>Se est&aacute;n empleando las anotaciones:</p>
                <ol>
                    <li>@Profile</li>
                    <li>@ActiveProfiles</li>
                    <li>@PropertySource</li>
                </ol> 
            </div>
            <h3><a href="#">Secci&oacute;n 4</a></h3>
            <div>
                <p>Hemos creado tambi&eacute;n una batería de pruebas JUnit</p>
            </div>
        </div>
    </body>
</html>
