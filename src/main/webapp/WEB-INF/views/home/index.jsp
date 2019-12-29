<%-- 
    Document   : index
    Created on : 25 ago. 2019, 13:37:06
    Author     : dcondori
--%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>index</title>
    </head>
    <body>
        <h3>Hello World!</h3>
        !Noticias |Actualidad|Deportes|Tecnologias <br>
        
        
        <security:authorize access="isAnonymous()">
            <a href="<c:url value='/login'/>">Login</a>          
        </security:authorize>
            
            
        <security:authorize access="isAuthenticated()">
              <security:authentication  var="username" property = "principal.username"/>
            Hola <b>${username}</b><a href="<c:url value='/logout'/>">Logout</a>    
        </security:authorize>
            
            
    </body>
</html>
