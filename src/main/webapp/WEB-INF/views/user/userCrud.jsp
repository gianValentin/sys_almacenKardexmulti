<%-- 
    Document   : categoriaCrud
    Created on : 18-nov-2019, 12:53:30
    Author     : gian
--%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <h1>User Crud!</h1>
        <div class="container">
            <a class="btn btn-danger" href="<c:url value="/home"/>">Regresar</a>
	<div class="card mt-5" >
		<div class="card-header">Registro de Usuarios:</div>
		<div class="row card-body">
			<div class="col-md-4 mb-5">				

				<form class="mt-3" id="add-form">
                                    
					<div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Username:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="username" readonly>
						</div>
					</div>	                                          
                                    
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Nombre:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="nombre" onkeyup="usernameGenerador()" required>
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Apellido:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="apellido" onkeyup="usernameGenerador()" required>
						</div>
					</div>                                                                    

                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Password:</label>
						<div class="col-sm-8">
                                                    <input type="password" class="form-control form-control-sm" name="password" required>
						</div>
					</div>	
                                    
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Fecha Nacimiento:</label>
						<div class="col-sm-8">
                                                    <input type="date" class="form-control form-control-sm" name="fecha_nac" required>
						</div>
					</div>
                                        
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Role:</label>
						<div class="col-sm-8">
                                                    <select name="id_role" id="cbxRole" class="custom-select " multiple="multiple" required>
								<!--cargando com AJAX-->
                                                    </select> 
						</div>
					</div>
                                    
					<div class="form-group row justify-content-md-center">
						<button type="submit" class="col-sm-8 btn btn-info">Agregar</button>												
					</div>
                                    
				</form>
			</div>

			<div class="col-md-8 table-responsive">
				<table class="table table-hover table-sm table-bordered">
					<thead class="thead-light">
						<tr>                                                   
                                                    <th>Username</th>
                                                    <th>Password</th>
                                                    <th>nombre</th>
                                                    <th>apellido</th>
                                                    <th>Fecha Nacimiento</th>
                                                    <th>Estado</th>                                                    
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
				<h5 class="modal-title" id="exampleModalLabel">Editar - User</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
                                    <form id="frm-editar">
                                        
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Id Usuario:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="id_user" readonly>
						</div>
					</div>	
                                        
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Username:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="username" readonly>
						</div>
					</div>	                                          
                                    
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Nombre:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="nombre" onkeyup="usernameGenerador()" required>
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Apellido:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="apellido" onkeyup="usernameGenerador()" required>
						</div>
					</div>                                                                    

                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Password:</label>
						<div class="col-sm-8">
                                                    <input type="password" class="form-control form-control-sm" name="password" required>
						</div>
					</div>	
                                    
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Fecha Nacimiento:</label>
						<div class="col-sm-8">
                                                    <input type="date" class="form-control form-control-sm" name="fecha_nac" required>
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
                cargarCbx();
                //Listar
                function findAll(){
                    $.get("<c:url value="/findAllUser"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                                                
			let template = '';
			response.forEach(obj => {	                            
                        var dateRegistro = new Date(obj.fecha_nac);                        
                        var dateRegistroFormat = dateRegistro.getDate() + "-" + (dateRegistro.getMonth() + 1) + "-" + dateRegistro.getFullYear();                        
			template += `
                            <tr rowId="`+obj.id_user+`">                                    
                                    <td>`+obj.username+`</td>                                    
                                    <td>`+obj.password+`</td>
                                    <td>`+obj.nombre+`</td>
                                    <td>`+obj.apellido+`</td>
                                    <td>`+dateRegistroFormat+`</td>
                                    <td>`+obj.estado+`</td>                                    
                                    <td><button class="btnEditar btn btn-outline-success" data-toggle="modal" data-target="#editarModal">Editar</button></td>
                                    <td><button class="btnEliminar btn btn-outline-danger">Eliminar</button></td>
                            </tr>`;
			});
			$('#lstObjertos').html(template);
                    });
                }
                function cargarCbx(){
                        $.get('<c:url value="/findAllRole"/>',function(response){                            
                            let template='';
                            response.forEach(obj => {                                
                                template+=`<option value="`+obj.id_role+`">`+obj.type+`</option>`;
                            });
                            $('#cbxRole').html(template);
                            //$('#cbxRoleEditar').html(template);
                        });
                }
                //Agregar
                $('#add-form').submit(e => {                    
                    e.preventDefault();                                                            
                    
                    var datos=$('#add-form').serializeArray();                                                            
                        datos.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'}); 
                        datos.push({name:"idRolesJson",value:JSON.stringify($("#cbxRole").val())});                        
                    
                    $.ajax({
                        type : "POST",
                         url : "<c:url value="/insertUser"/>",
                        data : datos,                       
                       success:function(response){                                                             
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
                    jsondata['id_user'] = id;
                    jsondata[csrfParameter]=csrfToken; 
                    $.post("<c:url value="/findIdUser"/>",jsondata,(response)=>{
                        var dateNac = new Date(response.fecha_nac);                        
                        var dateNacFormat = dateNac.getFullYear() + "-" + ("0"+(dateNac.getMonth() + 1)).slice(-2) + "-" + ("0" + dateNac.getDate()).slice(-2);                        
                        if(response!=null){
                            $('input[name="id_user"]','#frm-editar').val(response.id_user);                            
                            $('input[name="username"]','#frm-editar').val(response.username);
                            $('input[name="nombre"]','#frm-editar').val(response.nombre);
                            $('input[name="apellido"]','#frm-editar').val(response.apellido);
                            $('input[name="password"]','#frm-editar').val(response.password);
                            $('input[name="fecha_nac"]','#frm-editar').val(dateNacFormat);
                            //$('select[name ="id_role"]','#frm-editar').val([1,3]);
                        }
                    });		
                    idObjeto=id;
                });
                
                $('#btnModalEditar').click(function(){                      
                        var datos=$('#frm-editar').serializeArray();                                                            
                        datos.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'});                                                
                        $.post("<c:url value="/updateUser"/>",datos,(response)=>{
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
                        jsondata['id_user'] = id;
                        jsondata['${_csrf.parameterName}']='${_csrf.token}';                                                
                        $.post('<c:url value="/deleteUser"/>', jsondata,(response) => {                            
                            findAll();
                        });
                    }
                });     
                
            });
            function usernameGenerador(){                
                var nombre = $('input[name="nombre"]','#add-form').val();
                var apellido = $('input[name="apellido"]','#add-form').val();
                var username=nombre.substring(0,1)+apellido;
                $('input[name="username"]','#add-form').val(username);                
                var nombre = $('input[name="nombre"]','#frm-editar').val();
                var apellido = $('input[name="apellido"]','#frm-editar').val();
                var username=nombre.substring(0,1)+apellido;
                $('input[name="username"]','#frm-editar').val(username);
            }
            
        </script>
    </body>
</html>