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
        <h1>Producto Crud!</h1>
        <div class="container-fluit">
            <a class="btn btn-danger" href="<c:url value="/home"/>">Regresar</a>
	<div class="card mt-5" >
		<div class="card-header">Registro de Productos:</div>
		<div class="row card-body">
			<div class="col-md-4 mb-5">				

				<form class="mt-3" id="add-form">
                                    
					<div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Nombre Comercial:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" placeholder="Nombre Comercial" name="nombre_comercial" required>
						</div>
					</div>	
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Nombre Generico</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" placeholder="Nombre Generico" name="nombre_generico" required>
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Concentracion:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" placeholder="Concentracion" name="concentracion" required>
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Precio:</label>
						<div class="col-sm-8">
                                                    <input type="number" class="form-control form-control-sm" step="any" placeholder="precio" name="precio" required>
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Presentacion:</label>
						<div class="col-sm-8">
                                                    <select name="id_presentacion" id="cbxPresentacion" class="custom-select " required>
								<!--cargando com AJAX-->
                                                    </select> 
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Categoria:</label>
						<div class="col-sm-8">
                                                    <select name="id_categoria" id="cbxCategoria" class="custom-select " required>
								<!--cargando com AJAX-->
                                                    </select> 
						</div>
					</div>
                                    
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Stock:</label>
						<div class="col-sm-8">
                                                    <input type="number" min="1" class="form-control form-control-sm" placeholder="Stock" name="stock" required>
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Fecha Caducidad:</label>
						<div class="col-sm-8">
                                                    <input type="date" class="form-control form-control-sm" name="fecha_caducidad" required>
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
                                                    <th>Nombre Comercial</th>
                                                    <th>Nombre Generico</th>
                                                    <th>Concentracion</th>
                                                    <th>Precio</th>
                                                    <th>Presentacion</th>
                                                    <th>Categoria</th> 
                                                    <th>Stock</th>
                                                    <th>Fecha Registro</th>
                                                    <th>Fecha Caducidad</th>
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
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Id Producto:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="id_producto" readonly>
						</div>
					</div>	
                                        
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Nombre Comercial:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="nombre_comercial">
						</div>
					</div>	
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Nombre Generico</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="nombre_generico">
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Concentracion:</label>
						<div class="col-sm-8">
                                                    <input type="text" class="form-control form-control-sm" name="concentracion">
						</div>
					</div>
                                        
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Precio:</label>
						<div class="col-sm-8">
                                                    <input type="number" class="form-control form-control-sm" step="any" name="precio">
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Presentacion:</label>
						<div class="col-sm-8">
                                                    <select name="id_presentacion" id="cbxPresentacionModal" class="custom-select ">
								<!--cargando com AJAX-->
                                                    </select> 
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Categoria:</label>
						<div class="col-sm-8">
                                                    <select name="id_categoria" id="cbxCategoriaModal" class="custom-select ">
								<!--cargando com AJAX-->
                                                    </select> 
						</div>
					</div>
                                    
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Stock:</label>
						<div class="col-sm-8">
                                                    <input type="number" min="1" class="form-control form-control-sm" name="stock">
						</div>
					</div>
                                    
                                        <div class="form-group row">
						<label for="txtNombre" class="col-sm-4 col-form-label col-form-label-sm">Fecha Caducidad:</label>
						<div class="col-sm-8">
                                                    <input type="date" class="form-control form-control-sm" name="fecha_caducidad">
						</div>
					</div>
                                        
                                        <div class="form-group row">
						<label class="col-sm-4 col-form-label col-form-label-sm">Fecha Registro:</label>
						<div class="col-sm-8">
                                                    <input type="date" class="form-control form-control-sm" name="fecha_registro" readonly>
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
                    $.get("<c:url value="/findAllProducto"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                                                
			let template = '';
			response.forEach(obj => {	                            
                        var dateCaducidad = new Date(obj.fecha_caducidad);
                        var dateRegistro = new Date(obj.fecha_registro);
                        var dateCaducidadFormat = dateCaducidad.getDate() + "-" + (dateCaducidad.getMonth() + 1) + "-" + dateCaducidad.getFullYear();
                        var dateRegistroFormat = dateRegistro.getDate() + "-" + (dateRegistro.getMonth() + 1) + "-" + dateRegistro.getFullYear();
			template += `
                            <tr rowId="`+obj.id_producto+`">                                    
                                    <td>`+obj.nombre_comercial+`</td>
                                    <td>`+obj.nombre_generico+`</td>
                                    <td>`+obj.concentracion+`</td>
                                    <td>`+obj.precio+`</td>
                                    <td>`+obj.presentacion.presentacion+`</td>
                                    <td>`+obj.categoria.categoria+`</td>
                                    <td>`+obj.stock+`</td>
                                    <td>`+dateCaducidadFormat+`</td>
                                    <td>`+dateRegistroFormat+`</td>
                                    <td><button class="btnEditar btn btn-outline-success" data-toggle="modal" data-target="#editarModal">Editar</button></td>
                                    <td><button class="btnEliminar btn btn-outline-danger">Eliminar</button></td>
                            </tr>`;
			});
			$('#lstObjertos').html(template);
                    });
                }
                function cargarCbx(){
                        $.get('<c:url value="/findAllPresentacion"/>',function(response){                            
                            let template='<option value="0">Seleccione...</option>';
                            response.forEach(obj => {                                
                                template+=`<option value="`+obj.id_presentacion+`">`+obj.presentacion+`</option>`;
                            });
                            $('#cbxPresentacion').html(template);
                            $('#cbxPresentacionModal').html(template);
                        });
                        $.get('<c:url value="/findAllCategoria"/>',function(response){                            
                            let template='<option value="0">Seleccione...</option>';
                            response.forEach(obj => {                                
                                template+=`<option value="`+obj.id_categoria+`">`+obj.categoria+`</option>`;
                            });
                            $('#cbxCategoria').html(template);
                            $('#cbxCategoriaModal').html(template);
                        });
                }
                //Agregar
                $('#add-form').submit(e => {                    
                    e.preventDefault();                    
                    var datos=$('#add-form').serializeArray();                                                            
                    datos.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'});                                                               
                    $.ajax({
                        type : "POST",
                         url : "<c:url value="/insertProducto"/>",
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
                    jsondata['id_producto'] = id;
                    jsondata[csrfParameter]=csrfToken; 
                    $.post("<c:url value="/findIdProducto"/>",jsondata,(response)=>{
                        var dateCaducidad = new Date(response.fecha_caducidad);
                        var dateRegistro = new Date(response.fecha_registro);
                        var dateCaducidadFormat = dateCaducidad.getFullYear() + "-" + (dateCaducidad.getMonth() + 1) + "-" + dateCaducidad.getDate();
                        var dateResgistroFormat = dateRegistro.getFullYear() + "-" + (dateRegistro.getMonth() + 1) + "-" + dateRegistro.getDate();
                        if(response!=null){
                            $('input[name="id_producto"]','#frm-editar').val(response.id_producto);                            
                            $('input[name="nombre_comercial"]','#frm-editar').val(response.nombre_comercial);
                            $('input[name="nombre_generico"]','#frm-editar').val(response.nombre_generico);
                            $('input[name="concentracion"]','#frm-editar').val(response.concentracion);
                            $('input[name="precio"]','#frm-editar').val(response.precio);
                            $('input[name="stock"]','#frm-editar').val(response.stock);
                            $('input[name="fecha_caducidad"]','#frm-editar').val(dateCaducidadFormat);
                            $('input[name="fecha_registro"]','#frm-editar').val(dateResgistroFormat);
                            $('select[name ="id_presentacion"]','#frm-editar').val(response.presentacion.id_presentacion);
                            $('select[name ="id_categoria"]','#frm-editar').val(response.categoria.id_categoria);
                        }
                    });		
                    idObjeto=id;
                });
                
                $('#btnModalEditar').click(function(){                      
                        var datos=$('#frm-editar').serializeArray();                                                            
                        datos.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'});   
                                             
                        $.post("<c:url value="/updateProducto"/>",datos,(response)=>{
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
                        jsondata['id_producto'] = id;
                        jsondata[csrfParameter]=csrfToken;                                                
                        $.post('<c:url value="/deleteProducto"/>', jsondata,(response) => {                            
                            findAll();
                        });
                    }
                });
                
                
            });
        </script>
    </body>
</html>