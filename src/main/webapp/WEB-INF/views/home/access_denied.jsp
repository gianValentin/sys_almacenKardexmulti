<%-- 
    Document   : access_denied
    Created on : 13 oct. 2019, 09:33:45
    Author     : BHerrera
--%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/public/bootstrap/css/bootstrap.css" />" rel="stylesheet" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>access_denied</title>
    </head>
    <body>
         <h3>Erro!</h3>
    <security:authentication  var="username" property = "principal.username"/>
    
    Estimado (a) <b>${username}</b>;<br>
    Usted no tiene permiso para acceder a esta página.
    <a class="btn btn-danger" href="<c:url value="/home"/>">Regresar</a>
    <a href="<c:url value='/logout'/>">Logout</a>
    </body>
</html>