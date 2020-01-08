<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
            <h1 class="m-0 text-dark">Ingreso de Mercaderia</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">              
              <li class="breadcrumb-item active">Ingreso de Mercaderia</li>
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
          <section class="col-lg-4 connectedSortable">            
              <div class="card card-secondary">
              <div class="card-header">
                <h3 class="card-title">Formulario de Entrada</h3>
              </div>
              <div class="card-body">
                  <form id="frm-entrada">
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"> n° Factura</label>
                        <div class="col-sm-9">
                            <input type="text" autocomplete="off" name="factura" class="form-control form-group-sm is-warning">
                        </div>
                    </div>
                      
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"> Cod Producto</label>
                        <div class="col-sm-4 input-group">
                            <input type="text" autocomplete="off" name="codigo_producto" class="form-control form-group-sm readonly">
                            <span class="input-group-append">
                                <button type="button" id="btnBuscarProducto" class="btn btn-outline-warning" data-toggle="modal" data-target="#buscarProductoModal"><i class="fas fa-search"></i></button>
                            </span>
                        </div>
                        <label class="col-sm-2 col-form-label"> Stock</label>
                        <div class="col-sm-3">
                            <input type="text" autocomplete="off" name="stock" class="form-control form-group-sm readonly">
                        </div>
                    </div>
                      
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Nombre</label>
                        <div class="col-sm-9">
                            <input type="text" autocomplete="off" name="nombre" class="form-control form-group-sm readonly">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Cantidad</label>
                        <div class="col-sm-3">
                            <input type="number" autocomplete="off" name="cantidad" class="form-control form-group-sm is-warning" onkeypress="return isNumberKey(event)">
                        </div>
                        <label class="col-sm-3 col-form-label">Unidad Metrica</label>
                        <div class="col-sm-3">
                            <input type="text" autocomplete="off" name="unidad.unidad" class="form-control form-group-sm readonly">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Valor Unitario</label>
                        <div class="col-sm-3">
                            <input type="number" autocomplete="off" name="nombre" class="form-control form-group-sm is-warning" onkeypress="return isNumberKey(event)">
                        </div>
                    </div>  
                    
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Valor Venta</label>
                        <div class="col-sm-3">
                            <input type="text" autocomplete="off" name="nombre" class="form-control form-group-sm readonly">
                        </div>
                    </div>  
                    <hr>
                    <div class="row">                                                
                        <button type="button" class="btn btn-secondary col-sm-4 offset-sm-5" >Ingresar Detalle</button>                                                
                        <button type="button" class="btn btn-outline-info col-sm-3" >Limpiar</button>                        
                    </div>                      
                    
                </form>
              </div>
            </div>   
              
            <div class="card card-secondary">              
              <div class="card-body" style="height: 85px;">
                <div class="row">        
                    <div class="col-md-6">
                        <button type="button" class="btn btn-primary row col-12" >Guardar Ingreso</button>                       
                    </div>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-outline-danger row col-12" >Cancelar</button>                        
                    </div>                                        
                </div> 
              </div>
            </div>   
          </section>
          
          <section class="col-lg-8">
              <div class="card card-secondary" style="height: 600px;">
              <div class="card-header">
                <h3 class="card-title">Lista de Detalles</h3>
              </div>
              <div class="card-body">
                  <table id="tableDetalle" class="table table-bordered table-hover">
                      <thead class="thead-dark">
                          <tr>
                              <th>Codigo</th>
                              <th>Descripcion</th>
                              <th>Cantidad</th>
                              <th>Valor Unitario</th>
                          </tr>
                      </thead>
                      <tbody id="lstDetalle">
                          
                      </tbody>
                  </table>
              </div>
            </div>                          
          </section>
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
        <div class="modal fade" id="buscarProductoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">                        
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Editar - Producto</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        </div>                        
                        <div class="modal-body">
                            <div class="container">					
                                <table id="tablaProductosModal" class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <th>Codigo</th>
                                            <th>Nombre</th>
                                            <th>Selecccionar</th>
                                        </tr>
                                    </thead>
                                    <tbody id="lstProductoModal">                                            
                                    </tbody>
                                </table>
                            </div>
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
                //Listar
                function findAll(){
                    $.get("<c:url value="/findAllProducto"/>",function(response){                                                		
                        //const usuarios = JSON.parse(response);                        
			let template = '';
			response.forEach(producto => { 
                        var dateGenerado = new Date(producto.fecha_registro);
                        var dateGeneradoFormat = dateGenerado.getDate() + "-" + (dateGenerado.getMonth() + 1) + "-" + dateGenerado.getFullYear();
			template += `
                            <tr id_objeto="`+producto.id_producto+`">	
                                    <td>`+producto.codigo_producto+`</td>
                                    <td>`+producto.nombre+`</td>                                                                        
                                    <td><button class="btnSelect btn btn-outline-success">Seleccionar</button></td>                                    
                            </tr>`;
			});
			
                        $('#tablaProductosModal').DataTable().destroy();                        
                        $('#lstProductoModal').html(template);                        
                        $('#tablaProductosModal').DataTable();                                                
                    });
                }                
                //Buscar Producto
                $(document).on('click', '.btnSelect', (e) => {
                    $('#buscarProductoModal').modal('toggle');
                    var jsondata={};
                    const element = $(this)[0].activeElement.parentElement.parentElement;
                    const id = $(element).attr('id_objeto');                        
                    const csrfParameter = '${_csrf.parameterName}';
                    const csrfToken = '${_csrf.token}';                        
                    jsondata['id_producto'] = id;
                    jsondata[csrfParameter]=csrfToken; 
                    $.post("<c:url value="/findIdProducto"/>",jsondata,(response)=>{
                        console.log(response);
                        if(response!=null){
                            $('input[name="codigo_producto"]','#frm-entrada').val(response.codigo_producto);                            			
                        }
                    });		
                    idProducto=id;
                });
                
                $('#frm-editar').submit(function(e){
                        e.preventDefault();  
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
                        const id = $(element).attr('id_objeto');                        
                        const csrfParameter = '${_csrf.parameterName}';
                        const csrfToken = '${_csrf.token}';                        
                        jsondata['id_producto'] = id;
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
                        $('input[name="codigo_producto"]','#add-form').val(response);                            			
                    });
                });
                
                
                //TOOLS
                $(".readonly").keydown(function(e){
                    e.preventDefault();
                });                              
    });
    //funciones y procedimientos
    function isNumberKey(evt)
    {
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
    }
</script>

</body>
</html>
