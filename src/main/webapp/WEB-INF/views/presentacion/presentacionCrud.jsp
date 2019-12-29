<%-- 
    Document   : categoriaCrud
    Created on : 18-nov-2019, 12:53:30
    Author     : gian
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">        
        <link href="<c:url value="/public/bootstrap/css/bootstrap.css" />" rel="stylesheet" media="screen">
        <title>Sistema Botica</title>        
    </head>
    <body>
        <h1>Presentacion Crud!</h1>
        <div class="container">
            <a class="btn btn-danger" href="<c:url value="/home"/>">Regresar</a>
	<div class="card mt-5" >
		<div class="card-header">Registro de Productos:</div>
		<div class="row card-body">
			<div class="col-md-4 mb-5">				

				<form class="mt-3" id="add-form">
					<div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Presentacion:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" placeholder="Presentacion" id="txtPresentacion" required>
						</div>
					</div>														
					<div class="form-group row">
						<button type="submit" class="col-sm-12 btn btn-info">Agregar</button>												
					</div>
				</form>

			</div>

			<div class="col-md-8">
				<table class="table table-sm table-hover table-responsive-md">
					<thead class="thead-light">
						<tr>
                                                    <th>#</th>
                                                    <th>Presentacion</th>													
                                                    <th>Editar</th>
                                                    <th>Eliminar</th>			
						</tr>
					</thead>						
					<tbody id="lstObjertos">
						<!--cargando com AJAX-->
					</tbody>
				</table>
			</div>

		</div>
	</div>
	</div>
        
        <div class="modal fade" id="editarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-md" role="document">
			<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Editar - Presentacion</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
					<form id="frm-editar">
						<div class="form-group row">
							<label class="col-sm-3 col-form-label col-form-label-sm">Id Presentacion:</label>								
							<div class="col-md-4">
                                                            <input type="text" class="form-control form-control-sm" id="txtEditarId" readonly>
							</div>
						</div>
						<div class="form-group row">
							<label for="txtEditarPresentacion" class="col-sm-3 col-form-label col-form-label-sm">Presentacion:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control form-control-sm" placeholder="Presentacion" id="txtEditarPresentacion">
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" id="btnModalEditarCerrar" data-dismiss="modal">Cerrar</button>
				<button type="button" class="btn btn-success" id="btnModalEditar">Guardar</button>
			</div>
			</div>
		</div>
	</div>
        <script src="<c:url value="/public/jquery/jqueryAjax.min.js" />" crossorigin="anonymous"></script>
        <script src="<c:url value="/public/bootstrap/js/popper.min.js" />" crossorigin="anonymous"></script>        
        <script src="<c:url value="/public/bootstrap/js/bootstrap.min.js" />" crossorigin="anonymous"></script> 
        <script>
            $(document).ready(function(){        
                var idObjeto=0;
                findAll(); 
                //Listar
                function findAll(){
                    $.get("<c:url value="/findAllPresentacion"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);
                        console.log(response);
			let template = '';
			response.forEach(obj => {	                            
			template += `
                            <tr rowId="`+obj.id_presentacion+`">
                                    <td>#</td>
                                    <td>`+obj.presentacion+`</td>                                    
                                    <td><button class="btnEditar btn btn-outline-success" data-toggle="modal" data-target="#editarModal">Editar</button></td>
                                    <td><button class="btnEliminar btn btn-outline-danger">Eliminar</button></td>
                            </tr>`;
			});
			$('#lstObjertos').html(template);
                    });
                }
                //Agregar
                $('#add-form').submit(e => {                    
                    e.preventDefault();
                    
                    var jsondata={};
                    //datos del token
                    var csrfParameter = '${_csrf.parameterName}';
                    var csrfToken = '${_csrf.token}';
                    jsondata['parentId'] = 1;
                    jsondata[csrfParameter]=csrfToken;
                    //datos de controles                    
                    jsondata["presentacion"]=$("#txtPresentacion").val();                                       
                    
                    $.ajax({
                        type : "POST",
                         url : "<c:url value="/insertPresentacion"/>",
                        data : jsondata,
                       success:function(data){                                                      
                           findAll();
                           $('#add-form').trigger('reset');
                       }
                    });
                });
                //editar
                $(document).on('click', '.btnEditar', (e) => {
                    var jsondata={};
                    const element = $(this)[0].activeElement.parentElement.parentElement;
                    const id = $(element).attr('rowId');                        
                    const csrfParameter = '${_csrf.parameterName}';
                    const csrfToken = '${_csrf.token}';                        
                    jsondata['id_presentacion'] = id;
                    jsondata[csrfParameter]=csrfToken; 
                    $.post("<c:url value="/findIdPresentacion"/>",jsondata,(response)=>{
                        console.log(response);
                        if(response!=null){
                            $("#txtEditarId").val(response.id_presentacion);			
                            $("#txtEditarPresentacion").val(response.presentacion);                            
                        }
                    });		
                    idObjeto=id;
                });
                
                $('#btnModalEditar').click(function(){
                      
                        var jsondata={};
                        //datos del token
                        var csrfParameter = '${_csrf.parameterName}';
                        var csrfToken = '${_csrf.token}';                        
                        jsondata[csrfParameter]=csrfToken;
                        //datos de controles                    
                        jsondata["id_presentacion"]=idObjeto;
                        jsondata["presentacion"]=$("#txtEditarPresentacion").val();                        
                      
                        $.post("<c:url value="/updatePresentacion"/>",jsondata,(response)=>{
                              if(response=="OK"){
                                      findAll();
                                      $("#btnModalEditarCerrar").click();
                              }else{
                                      console.log(response);
                              }
                        });	  
                });
                //Eliminar
                $(document).on('click', '.btnEliminar', (e) => {
                    if(confirm('Estas seguro de Eliminar este Producto?')) {
                        var jsondata={};
                        const element = $(this)[0].activeElement.parentElement.parentElement;
                        const id = $(element).attr('rowId');                        
                        const csrfParameter = '${_csrf.parameterName}';
                        const csrfToken = '${_csrf.token}';                        
                        jsondata['id_presentacion'] = id;
                        jsondata[csrfParameter]=csrfToken;                                                
                        $.post('<c:url value="/deletePresentacion"/>', jsondata,(response) => {                            
                            findAll();
                        });
                    }
                });
                
                
            });
        </script>
    </body>
</html>