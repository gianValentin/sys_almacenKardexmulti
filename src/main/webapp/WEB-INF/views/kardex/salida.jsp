<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>KardexMulti | Salidas</title>
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
            <h1 class="m-0 text-dark">Salida de Mercaderia</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">              
              <li class="breadcrumb-item active">Salida de Mercaderia</li>
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
                            <input type="text" autocomplete="off" name="factura" class="form-control form-group-sm is-warning" required>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"> Fecha Factura</label>
                        <div class="col-sm-4">
                            <input type="date" autocomplete="off" name="fecha_factura" class="form-control form-group-sm is-warning" required>
                        </div>
                    </div>  
                      <hr>
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label"> Cod Producto</label>
                        <div class="col-sm-4 input-group">
                            <input type="hidden" name="id_producto" />
                            <input type="text" autocomplete="off" name="codigo_producto" class="form-control form-group-sm readonly" required>
                            <span class="input-group-append">
                                <button type="button" id="btnBuscarProducto" class="btn btn-outline-warning" ><i class="fas fa-search"></i></button>
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
                            <input type="number" step=".01" autocomplete="off" name="cantidad" class="form-control form-group-sm is-warning" onkeypress="return isNumberKey(event)" onkeyup="calcularValorVenta(event)" required>
                        </div>
                        <label class="col-sm-3 col-form-label">Unidad Metrica</label>
                        <div class="col-sm-3">
                            <input type="text" autocomplete="off" name="unidad.unidad" class="form-control form-group-sm readonly">
                        </div>
                    </div>
                    
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Valor Unitario</label>
                        <div class="col-sm-3">
                            <input type="number" step=".01" autocomplete="off" name="valor_unitario" class="form-control form-group-sm is-warning" onkeypress="return isNumberKey(event)" onkeyup="calcularValorVenta(event)" required>
                        </div>
                    </div>  
                    
                    <div class="form-group row">
                        <label class="col-sm-3 col-form-label">Valor Venta</label>
                        <div class="col-sm-3">
                            <input type="text" autocomplete="off" name="valor_venta" class="form-control form-group-sm readonly">
                        </div>
                    </div>  
                    <hr>
                    <div class="row">                                                
                        <button type="submit" class="btn btn-secondary col-sm-4 offset-sm-5" >Ingresar Detalle</button>                                                
                        <button type="button" class="btn btn-outline-info col-sm-3">Limpiar</button>                        
                    </div>                      
                    
                </form>
              </div>
            </div>   
              
            <div class="card card-secondary">              
              <div class="card-body">
                <div class="row">        
                    <div class="col-md-6">
                        <button type="button" class="btn btn-primary row col-12" id="btnGuardarIngreso">Guardar Ingreso</button>                       
                    </div>
                    <div class="col-md-6">
                        <button type="button" class="btn btn-outline-danger row col-12" >Cancelar</button>                        
                    </div>                                        
                </div> 
              </div>
            </div>   
          </section>
          
          <section class="col-lg-8">
              <div class="card card-secondary">
                <div class="card-header">
                  <h3 class="card-title">Lista de Detalles</h3>
                </div>
                <div class="card-body" style="height: 550px; overflow: scroll">
                    <table id="tableDetalle" class="table table-sm table-bordered table-hover">
                        <thead class="thead-light">
                            <tr>
                                <th>Codigo</th>
                                <th>Descripcion</th>
                                <th>Cantidad</th>
                                <th>Valor Unitario</th>
                                <th>Valor Venta</th>
                                <th>Quitar</th>
                            </tr>
                        </thead>
                        <tbody id="lstDetalle">

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row justify-content-end">
                <div class="card card-secondary col-md-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-6">IGV:</div>
                            <div class="col-md-6" id="precioIgv">000.00</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">Sub Toal:</div>
                            <div class="col-md-6" id="precioSubTotal">000.00</div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">TOTAL:</div>
                            <div class="col-md-6" id="precioTotal">000.00</div>
                        </div>                        
                    </div>
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
                var lstDetalleIngreso=[];                                                
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
                $(document).on('click','#btnBuscarProducto',(e) =>{
                    findAll();
                    $('#buscarProductoModal').modal('show');
                });
                //Seleccionar Producto
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
                        if(response!=null){
                            $('input[name="codigo_producto"]','#frm-entrada').val(response.codigo_producto);                            
                            $('input[name="id_producto"]','#frm-entrada').val(response.id_producto);                                                        
                            findStockByProducto(response.id_producto);
                            $('input[name="nombre"]','#frm-entrada').val(response.nombre);
                            $('input[name="unidad.unidad"]','#frm-entrada').val(response.unidad.unidad);  
                        }
                    });		                    
                });
                
                //Buscar Stock
                
                function findStockByProducto(id_producto){                    
                    var jsondata={};
                    jsondata['${_csrf.parameterName}']='${_csrf.token}';
                    jsondata['id_producto'] = id_producto;
                    $.post("<c:url value="/stockFindProducto"/>",jsondata,(response)=>{                                            
                        $('input[name="stock"]','#frm-entrada').val(response);
                    });                    
                }
                
                //Agregar Detalle a Memoria
                $('#frm-entrada').submit(function(e){
                        e.preventDefault();                          
                        let obj={
                            id_producto:$('input[name="id_producto"]','#frm-entrada').val(),
                            codigo_producto:$('input[name="codigo_producto"]','#frm-entrada').val(),
                            nombre:$('input[name="nombre"]','#frm-entrada').val(),
                            cantidad:$('input[name="cantidad"]','#frm-entrada').val(),
                            precio:$('input[name="valor_unitario"]','#frm-entrada').val(),
                            valor_venta:$('input[name="valor_venta"]','#frm-entrada').val()
                        };
                        lstDetalleIngreso.push(obj); 
                        //Limpiar controles                        
                        $(this).find('input, select, textarea').not('input[name="fecha_factura"]','#frm-entrada').not('input[name="factura"]','#frm-entrada').val('');
                        cargarListaDetalles();
                });
                
                //Quitar Detalle a Memoria
                $(document).on('click', '.btnQuitar', (e) => {
                    const element = $(this)[0].activeElement.parentElement.parentElement;                    
                    const id = $(element).attr('idProducto');                                          
                    var pos=0;
                    lstDetalleIngreso.forEach(obj => {                       
                        if(obj['id_producto']===id){
                            lstDetalleIngreso.splice(pos,1);
                        }
                        pos++;
                    });
                    cargarListaDetalles();
                });                
                
                
                //Cargar Lista Detalles
                function cargarListaDetalles(){
                    let template = ``;
                    lstDetalleIngreso.forEach(obj => {                        
                        template += `
                                <tr idProducto="`+obj.id_producto+`">
                                    <td>`+obj.codigo_producto+`</td>
                                    <td>`+obj.nombre+`</td>
                                    <td>`+obj.cantidad+`</td>
                                    <td>`+obj.precio+`</td>
                                    <td>`+obj.valor_venta+`</td>
                                    <td><button class="btnQuitar btn btn-outline-danger">Quitar</button></td>
                                </tr>
                            `;
                    });
                    $("#lstDetalle").html(template);
                }                                                                
                
                //Guardar Ingreso
                $(document).on('click', '#btnGuardarIngreso', (e) => {
                    if(confirm('Esta Seguro de Finalizar el Ingreso?')) {
                        if(!lstDetalleIngreso.length >0){
                            alert("No encontraron Ingresos!");
                            return false;
                        }                                             
                        
                        var data = [];
                        data.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'});
                        data.push({name:'factura',value:$('input[name="factura"]','#frm-entrada').val()}); 
                        data.push({name:'fecha_factura',value:$('input[name="fecha_factura"]','#frm-entrada').val()}); 
                        data.push({name:'json',value:JSON.stringify(lstDetalleIngreso)});                         
                        $.post("<c:url value="/createEntrada"/>",data,(response)=>{
                            console.log(response);
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
    if (charCode > 31 && (charCode < 46 || charCode > 57))
        return false;        
    return true;
    }
    
    function calcularValorVenta(evt)
    {    
        var cantidad = $('input[name="cantidad"]','#frm-entrada').val();
        var val_unitario = $('input[name="valor_unitario"]','#frm-entrada').val();
        //evt.srcElement.value
        $('input[name="valor_venta"]','#frm-entrada').val(val_unitario*cantidad);      
    }
</script>

</body>
</html>
