<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>

<c:import url="/saludos.xml" var="docXml"/>

<c:import url="/saludos.xslt" var="docXsl"/>

<x:transform doc="${docXml}" xslt="${docXsl}"/>


