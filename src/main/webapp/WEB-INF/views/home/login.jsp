<%-- 
    Document   : login
    Created on : 13 oct. 2019, 11:44:51
    Author     : BHerrera
--%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/public/bootstrap/css/bootstrap.css" />" rel="stylesheet" media="screen">
        <title>Login</title>
    </head>
    <body>
        
        <!--/senati/login-->
                                                    
    <div class="modal-dialog modal-md ">
        <div class="col-sm-12 main-section">
            <div class="modal-content">              
              <div class="row">
                <div class="col-md-12">                  
                  <h1 class="mt-5 text-center" id="titulo">
                    Botica
                  </h1>
                    <c:url var="loginURL" value="/login"/> 
                    <form class="col-md-12 mt-4" id="login-form" method="post" action="${loginURL}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                    <!--si existe error de logeo-->
                        <c:if test="${param.error !=null}">
                            <p style="color:red">
                                Error, username y/o password incorrecto!
                            </p>
                        </c:if>
                        <c:if test="${param.logout !=null}">
                        <p style="color:green">
                                Usted a cerrado sesión!
                            </p>
                        </c:if>
                        <div class="form-group" id="usuario-grupo">
                          <label for="user">Usuario:</label>
                          <input type="text" class="form-control" placeholder="Nombre de Usuario" id="user" name="txtUsername"/>
                        </div>
                        <div class="form-group" id="contraseña-grupo">
                          <label for="pass">Contraseña:</label>
                          <input type="password" class="form-control" placeholder="Contraseña" id="pass" name="txtPassword"/>
                        </div>
                        
                        <button type="submit" class="btn btn-dark mt-3 mb-3" >Ingresar</button>
                    </form>
                    
                </div>
              </div>
            </div>
        </div>
    </div>
                                    
    </body>
</html>
<style>
.main-section{
  margin:0 auto;
  margin-top: 10%;
  padding: 0;
}

.modal-content{
  background-color:#bfc9ca;
  opacity: .88  ;
  padding: 0 20px;
  box-shadow: 0px 0px 20px  #aeb6bf;
}

#titulo{
  font-size:45px;
  font-family: "Georgia", Times, serif;
  font-style:normal;
  color: #34495e ;
  font-weight: bold;
}
</style>
