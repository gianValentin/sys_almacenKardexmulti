<nav class="navbar navbar-expand-lg navbar-light bg-light ">
	  <a class="navbar-brand" href="<c:url value="/home" />">Sistema Botica</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>

	  <div class="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
              <security:authentication  var="username" property = "principal.username"/>
              <div class="form-inline ">
                  <b class="forn-control mr-3">${username}</b>                  
                  <a class="btn btn-outline-danger my-2 my-sm-0" href="<c:url value="/logout" />">Cerrar Sesion</a>
              </div>
	  </div>
</nav>
