<%-- 
    Document   : home
    Created on : 18-nov-2019, 9:36:21
    Author     : gian
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/public/bootstrap/css/bootstrap.css" />" rel="stylesheet" media="screen">        
        <title>Sistema - Home</title>
    </head>
    <body>
        <%@include file="../includes/navBar.jsp" %>        
        <div class="row">
            <div class="col-md-2">
                <%@include file="../includes/navHorizontal.jsp" %>  
            </div>
            <div class="col-md-10">
                <div class="container">
                    Este Es mi Super Espacio
                </div>
            </div>
        </div>                
    </body>
</html>
