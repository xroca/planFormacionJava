<%@tag body-content="scriptless" description="muestra una imagen en la página JSP" pageEncoding="UTF-8"%>

<%-- Taglib directives can be specified here: --%>
<%--
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
--%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%--
<%@attribute name="title" required="true"%>
<%@attribute name="author"%>
<%@attribute name="price_info" fragment="true"%>
--%>

<%-- Use expression language to work with normal attributes or use --%>
<%-- the <jsp:invoke> or <jsp:doBody> actions to invoke JSP fragments or tag body: --%>
<%--
<table border="1">
    <tr>
        <td align="center"><h2>${title}</h2></td>
    </tr>
    <tr>
        <td><em>Author:</em><strong>${author}</strong></td>
    </tr>
    <tr>
        <td><em>Price Info:</em><jsp:invoke fragment="price_info"/></td>
    </tr>
    <tr>
        <td colspan="2"><em>Book Info:</em><jsp:doBody/></td>
    </tr>
</table>
--%>
<%@attribute name="cabecera" rtexprvalue="true" required="true" description="Cabecera HTML de 1 a 6"%>
<%@attribute name="imagen" rtexprvalue="true" required="true" description="Nombre de la imagen"%>
<%@attribute name="ancho" rtexprvalue="true" required="true" description="Ancho de la imagen"%>
<%@attribute name="alto" rtexprvalue="true" required="true" description="Alto de la imagen"%>
<%@attribute name="dir" rtexprvalue="true" required="true" description="Directorio donde se encuentra la imagen"%>
<img src="${dir}${imagen}" width="${ancho}" height="${alto}" alt="BuenaNoticia" align="left"/>
<h${cabecera}><jsp:doBody/></h${cabecera}>


