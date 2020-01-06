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
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Log in</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@include file="../includes/cdn.jsp" %>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="#"><b>KARDEX</b>MULTI</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">Ingrese para iniciar su session</p>
      <c:url var="loginURL" value="/login"/> 
      <form  method="post" action="${loginURL}">
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
        <div class="input-group mb-3">
          <input type="text" class="form-control" placeholder="Email" name="txtUsername">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="Password" name="txtPassword">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">          
          <!-- /.col -->
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">Sign In</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->

</body>
</html>