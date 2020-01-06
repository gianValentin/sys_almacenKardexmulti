<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 3 | Dashboard</title>
  <%@include file="../includes/cdn.jsp" %>
</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">
 <%@include file="../includes/navBar.jsp" %>
 <%@include file="../includes/navHorizontal.jsp" %>
  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">Producto</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Producto</a></li>
              <li class="breadcrumb-item active">Categoria</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
        <!-- Small boxes (Stat box) -->
        
        <!-- /.row -->
        <!-- Main row -->
        <div class="row">
          <!-- Left col -->
          <section class="col-lg-12 connectedSortable">
            <!-- Custom tabs (Charts with tabs)-->

            <div class="card card-secondary">
              <div class="card-header">
                <h3 class="card-title">Formulario de Producto</h3>
              </div>
              <div class="card-body">
                <form id="add-form">
                  <div class="row">
                    <div class="col-md-3">
                      <div class="form-group">
                        <label>Categoria</label>
                        <select class="custom-select" name="categoria.id_categoria" id="cbxCategoria" required>                            
                        </select>
                      </div>
                        
                      <div class="form-group">
                        <label>Tipo Mercaderia</label>
                        <select class="custom-select" name="tipo.id_tipo" id="cbxTipo" required>
                        </select>
                      </div>
                        
                      <div class="form-group">
                        <div class="row">                          
                          <button type="submit" class="col-md-7 btn btn-primary mr-2">Guardar</button>   
                          <button type="button" class="col-md-4 btn btn-danger" onclick="$('#add-form').trigger('reset');">Cancelar</button>
                        </div>               
                      </div>
                        
                    </div>
                      
                    <div class="col-md-3">
                      <div class="form-group">
                        <label for="txtPrueba">Nombre Del Producto o Articulo</label>
                        <input type="text" autocomplete="off" class="form-control" id="txtPrueba" name="categoria" placeholder="categoria" required>
                      </div>
                        
                      <div class="form-group">
                        <label>Unidad Metrica</label>
                        <select class="custom-select" name="unidad.id_unidad" id="cbxUnidad" required>
                        </select>
                      </div>
                        
                    </div>
                      
                    <div class="col-md-3">
                      <div class="form-group">
                        <label for="txtPrueba">Nombre Reducido Del Producto</label>
                        <input type="text" autocomplete="off" class="form-control" id="txtPrueba" name="status" placeholder="Nombre Reducido" required>
                      </div>
                        
                      <div class="form-group">
                        <label for="txtPrueba">Abreviatura Unidad</label>
                        <input type="text" autocomplete="off" class="form-control" id="txtPrueba" name="status" placeholder="Abreviatura Unidad" required>
                      </div>
                    </div> 
                      
                    <div class="col-md-3">
                      <div class="form-group">
                        <label for="txtPrueba">Estado</label>
                        <select class="custom-select" name="unidad.id_unidad" id="cbxUnidad">
                            <option value="ACTIVE">Activado</option>
                            <option value="DESACTIVE">Desactivado</option>
                        </select>
                      </div>
                        
                      <div class="form-group">
                        <label for="txtPrueba">Codigo Producto</label>
                        <div class="input-group">
                            <input type="text" autocomplete="off" class="form-control" id="txtPrueba" name="Codigo" required readonly>
                            <span class="input-group-append">
                                <button class="btn btn-success btn-flat" type="button" id="btnGenerarCodigo">Generar Auto</button>
                            </span>
                        </div>                        
                      </div>
                    </div> 
                      
                  </div>
                </form>
              </div>
            </div>

            <div class="card card-secondary">
              <div class="card-header">
                <h3 class="card-title">Lista de Productos</h3>
              </div>

              <div class="card-body">
                <table id="tableProd" class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <th>Codigo</th>
                      <th>Nombre</th>
                      <th>Nombre Reducido</th>
                      <th>Unidad Metrica</th>
                      <th>Estado</th>
                      <th>Editar</th>
                      <th>Eliminar</th>
                    </tr>
                  </thead>
                  <tbody id="lstCategorias">
                  </tbody>
                </table>
              </div>
            </div>

            <!-- /.card -->
          </section>
          <!-- /.Left col -->

          <!-- right col -->
        </div>
        <!-- /.row (main row) -->
      </div><!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  <%@include file="../includes/footer.jsp" %>


</div>
        <div class="modal fade" id="editarCategoriaModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Editar - Categoria</h5>
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<div class="container">
					<form id="frm-editar">
                                            <input type="hidden" name="id_categoria"/>
						<div class="form-group row">
							<label class="col-sm-3 col-form-label col-form-label-sm">Codigo Categoria:</label>								
							<div class="col-md-4">
                                                            <input type="text" class="form-control form-control-sm" placeholder="codigo" name="codigo">
							</div>
						</div>
						<div class="form-group row">
							<label for="txtEditarCategoria" class="col-sm-3 col-form-label col-form-label-sm">Categoria:</label>
							<div class="col-sm-4">
								<input type="text" class="form-control form-control-sm" placeholder="Categoria" name="categoria">
							</div>
						</div>
						<div class="form-group row">
							<label for="txtEditarDescripcion" class="col-sm-3 col-form-label col-form-label-sm">Estado</label>
							<div class="col-sm-9">
                                                            <input type="text" class="form-control form-control-sm" placeholder="Estatus" name="status">
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
  <%@include file="../includes/scripts.jsp" %>
  <!-- ./table -->
    <script src="<c:url value="public/plugins/datatables/jquery.dataTables.js" />"></script>
    <script src="<c:url value="public/plugins/datatables-bs4/js/dataTables.bootstrap4.js" />"></script>        
<script>
 $(document).ready(function(){     
                var idProducto=0;
                findAll(); 
                findAllCbx();
                //Listar
                function findAll(){
                    $.get("<c:url value="/findAllProducto"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                        
			let template = '';
			response.forEach(producto => {                            
			template += `
                            <tr categoriaId="`+producto.id_producto+`">	
                                    <td>`+producto.codigo_producto+`</td>
                                    <td>`+producto.nombre+`</td>
                                    <td>`+producto.nombre_reducido+`</td>
                                    <td>`+producto.abrev_unidad+`</td>                                                                        
                                    <td> <input type="checkbox"  name="vehicle3" value="Boat" checked> `+producto.status+`</td>
                                    <td><button class="btnEditar btn btn-outline-success" data-toggle="modal" data-target="#editarCategoriaModal">Editar</button></td>
                                    <td><button class="btnEliminar btn btn-outline-danger">Eliminar</button></td>
                            </tr>`;
			});
			
                        $('#tableProd').DataTable().destroy();                        
                        $('#lstCategorias').html(template);                        
                        $('#tableProd').DataTable();                                                
                    });
                }
                
                function findAllCbx(){
                    $.get("<c:url value="/findAllCategoria"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                        
			let template = '<option value="">Seleccione</option>';
			response.forEach(categoria => {                            
			template += `
                                <option value="`+categoria.id_categoria+`">`+categoria.categoria+`</option>
                            `;
			});			                        
                        $('#cbxCategoria').html(template);                                                
                    });
                    
                    $.get("<c:url value="/findAllTipo"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                        
			let template = '<option value="">Seleccione</option>';
			response.forEach(tipo => {                            
			template += `
                                <option value="`+tipo.id_tipo+`">`+tipo.tipo+`</option>
                            `;
			});			                        
                        $('#cbxTipo').html(template);                                                
                    });
                    
                    $.get("<c:url value="/findAllUnidad"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                        
			let template = '<option value="">Seleccione</option>';
			response.forEach(unidad => {                            
			template += `
                                <option value="`+unidad.id_unidad+`">`+unidad.unidad+`</option>
                            `;
			});			                        
                        $('#cbxUnidad').html(template);                                                
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
                    const id = $(element).attr('categoriaId');                        
                    const csrfParameter = '${_csrf.parameterName}';
                    const csrfToken = '${_csrf.token}';                        
                    jsondata['id_categoria'] = id;
                    jsondata[csrfParameter]=csrfToken; 
                    $.post("<c:url value="/findIdCategoria"/>",jsondata,(response)=>{
                        console.log(response);
                        if(response!=null){
                            $('input[name="id_categoria"]','#frm-editar').val(response.id_categoria);                            			
                            $('input[name="codigo"]','#frm-editar').val(response.codigo);                            			
                            $('input[name="categoria"]','#frm-editar').val(response.categoria);                            			
                            $('input[name="status"]','#frm-editar').val(response.status);                            			
                        }
                    });		
                    idProducto=id;
                });
                
                $('#btnModalEditar').click(function(){
                      
                        var datos=$('#frm-editar').serializeArray(); 
                        console.log(datos);
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
                        const id = $(element).attr('categoriaId');                        
                        const csrfParameter = '${_csrf.parameterName}';
                        const csrfToken = '${_csrf.token}';                        
                        jsondata['id_categoria'] = id;
                        jsondata[csrfParameter]=csrfToken;                                                
                        $.post('<c:url value="/deleteProducto"/>', jsondata,(response) => {                            
                            findAll();
                        });
                    }
                });             
                
                //Obtener Nuevo Codigo
                $(document).on('click', '#btnGenerarCodigo', (e) => {
                    $.get("<c:url value="/nuevoCodigo"/>",(response)=>{
                        console.log(response);
                        $('input[name="Codigo"]','#add-form').val(response);                            			
                    });
                });
    });
</script>

</body>
</html>
