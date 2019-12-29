<%-- 
    Document   : venta
    Created on : 18-nov-2019, 10:16:14
    Author     : gian
--%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">        
        <link href="<c:url value="/public/bootstrap/css/bootstrap.css" />" rel="stylesheet" media="screen">
        <title>Sistema - Venta</title>
    </head>
    <body>        
        <%@include file="../includes/navBar.jsp" %>        
        <div class="row">
            <div class="col-md-2">
                <%@include file="../includes/navHorizontal.jsp" %>  
            </div>
            <div class="col-md-10">
                <h4>Generar de Ventas</h4>
                <div class="container-fluit mt-3">            
                    <div class="row">
                        <div class="col-md-4">
                            <div class="container">
                                <div class="card">
                                    <div class="card-header">Busqueda de Medicamentos</div>
                                    <div class="card-body">
                                        <div class="form-group row">
                                            <label class="col-sm-4 col-form-label col-form-label-sm">BUSQUEDA:</label>
                                            <div class="col-sm-8">
                                                <input type="text" class="form-control form-control-sm" id="txtBusqueda">
                                            </div>
                                        </div>	
                                        <div class="row container">
                                            <table class="table table-bordered table-sm">
                                                <thead class="thead-light">
                                                    <tr>
                                                        <th>Nombre</th>
                                                        <th>Precio</th>
                                                        <th>Accion</th>
                                                    </tr>
                                                </thead>
                                                <tbody id="lstBusquedaMedicamento">
                                                    <!--cardado por AJAX-->                                            
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8">
                            <div class="container">
                                <div class="row card">
                                    <div class="card-header">Medicamentos En Lista</div>
                                    <div class="card-body" style="height: 500px; overflow: scroll">
                                        <table class="table table-bordered">
                                            <thead class="thead-light">
                                                <tr>
                                                    <th>Nombre</th>
                                                    <th>Concentracion</th>
                                                    <th>precio Unidad</th>
                                                    <th>Camtidad</th>
                                                    <th>precio Sumado</th>
                                                    <th>Quitar</th>
                                                </tr>
                                            </thead>
                                            <tbody id="lstMedicamentos">

                                            </tbody>
                                        </table>

                                    </div>
                                </div>
                                <div class="row justify-content-end mt-3">
                                    <div class="col-md-4">                                 
                                        <div class="card border-success">
                                            <div class="card-header border-success">Total</div>
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
                                        <button class="btnFinalizar btn btn-success col-sm-12 mt-3" data-toggle="modal" data-target="#finalizarModal">Finalizar</button>                                
                                    </div>                            
                                </div>
                            </div>                    
                        </div>
                    </div>
                </div>               
                <security:authentication  var="username" property = "principal.username"/>
                <div class="modal fade" id="finalizarModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                        <div class="modal-dialog modal-md" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Finalizar Compra - Botica</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                            </button>
                                    </div>
                                    <div class="modal-body">
                                        <div class="container">

                                            <div class="form-group row">
                                                <label class="col-sm-4 col-form-label col-form-label-sm">Usuario en Sistema:</label>
                                                <div class="col-sm-8">                                            
                                                    <input type="text" class="form-control form-control-sm" name="usuario" value="${username}" readonly>
                                                </div>
                                            </div>
                                            <hr>


                                            <div class="row">
                                                <label for="chbxTipoCliente" class="col-sm-4 col-form-label col-form-label-sm">Tipo Clienet:</label>
                                                <div class="col-md-8">
                                                    <div class="form-check">
                                                        <input class="form-check-input" type="checkbox" id="chbxTipoCliente" data-target="#collapseLista" data-toggle="collapse" aria-controls="collapseExample">
                                                        <label class="form-check-label" for="exampleRadios2">
                                                          Cliente Registrado
                                                        </label>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="row collapse" id="collapseLista">
                                                <div class="col-md-12 card card-body">

                                                    <div class="form-group row">
                                                        <label class="col-sm-4 col-form-label col-form-label-sm">Usuario:</label>
                                                        <div class="col-sm-8">
                                                            <input type="text" class="form-control form-control-sm" id="txtMostrarCliente" readonly>
                                                        </div>
                                                    </div>                                                  

                                                    <table class="table">
                                                        <thead class="thead-light">
                                                            <tr>
                                                                <th>Nombre</th>
                                                                <th>Apellido</th>
                                                                <th>Escoger</th>
                                                            </tr>
                                                        </thead>
                                                        <tbody id="lstClientes">

                                                        </tbody>
                                                    </table>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="modal-footer">
                                            <button type="button" class="btn btn-secondary" id="btnModalFinalizarCerrar" data-dismiss="modal">Cerrar</button>
                                            <button type="button" class="btn btn-success" id="btnModalGuardar">Guarda</button>
                                    </div>                            
                                </div>
                        </div>
                </div>
            </div>
        </div>          
        <script src="<c:url value="/public/jquery/jqueryAjax.min.js" />" crossorigin="anonymous"></script>
        <script src="<c:url value="/public/bootstrap/js/popper.min.js" />" crossorigin="anonymous"></script>        
        <script src="<c:url value="/public/bootstrap/js/bootstrap.min.js" />" crossorigin="anonymous"></script> 
        <script>
            $(document).ready(function(){                
                //Funciones y Procedimientos
                cargarListaClientes();
                //variables nivel clase
                var listaProductos=[];
                var idCliente=0;
                
                $("#txtBusqueda").keyup(function(){                
                    var jsonData={};
                    jsonData['${_csrf.parameterName}']='${_csrf.token}';
                    jsonData['txtBusqueda']=this.value;                    
                    $.post("<c:url value="/findByNombre"/>",jsonData,(response)=>{
                        let template = ``;
                        response.forEach(obj => {
                        template +=`
                            <tr idProducto="`+obj.id_producto+`" nombre="`+obj.nombre_comercial+`" precio="`+obj.precio+`" concentracion="`+obj.concentracion+`">
                                <td>`+obj.nombre_comercial+`</td>
                                <td>`+obj.precio+`</td>
                                <td>
                                    <div class="input-group" style="width: 150px;">
                                        <input type="number" class="form-control" value="1" min="1" max="50"/>
                                        <div class="input-group-append">
                                            <button class="btnAgregar btn btn-outline-success">+</button>
                                        </div>
                                    </div>                                                                                  
                                </td>
                                </td>
                            </tr>`; 
                        });                        
                        $("#lstBusquedaMedicamento").html(template);
                    });                                        
                });
                
                $(document).on('click', '.btnAgregar', (e) => {
                    const elementTD = $(this)[0].activeElement.parentElement.parentElement.parentElement.parentElement;
                    const elementDIV = $(this)[0].activeElement.parentElement.parentElement;
                    
                    const id = $(elementTD).attr('idProducto');
                    const nombre = $(elementTD).attr('nombre');
                    const precio = $(elementTD).attr('precio');
                    const concentracion = $(elementTD).attr('concentracion');
                    const value = $(elementDIV).children("input").val();
                    
                    var objeto = {id_producto:id,cantidad:value,nombre:nombre,precio:precio,concentracion:concentracion};
                    listaProductos.push(objeto);           
                    
                    cargarListaAgregadoMedicamento();
                });
                
                function cargarListaAgregadoMedicamento(){
                    let template = ``;
                    var precioTotal=0;
                    var precioSubTotal=0;
                    var precioIgv=0;
                    listaProductos.forEach(obj => {
                        var precioPorCatidad = obj.precio*obj.cantidad;
                        precioTotal+=precioPorCatidad;                        
                        template +=`                                
                                <tr idProducto="`+obj.id_producto+`">
                                    <td>`+obj.nombre+`</td>
                                    <td>`+obj.concentracion+`</td>
                                    <td>`+obj.precio+`</td>
                                    <td>`+obj.cantidad+`</td>
                                    <td>`+(Math.round(precioPorCatidad*100)/100)+`</td>                                    
                                    <td><button class="btnQuitar btn btn-outline-danger">Quitar</button></td>
                                </tr>
                            `;
                    });
                    precioIgv=precioTotal*0.18;
                    precioSubTotal=precioTotal-precioIgv;
                    $("#precioIgv").html((Math.round(precioIgv*100)/100) +"    S/.");
                    $("#precioSubTotal").html((Math.round(precioSubTotal*100)/100)+"  S/.");
                    $("#precioTotal").html((Math.round(precioTotal*100)/100)+"    S/.");
                    
                    $("#lstMedicamentos").html(template);
                }
                
                $(document).on('click', '.btnQuitar', (e) => {
                    const element = $(this)[0].activeElement.parentElement.parentElement;                    
                    const id = $(element).attr('idProducto');                                          
                    var pos=0;
                    listaProductos.forEach(obj => {                       
                        if(obj['id_producto']===id){
                            listaProductos.splice(pos,1);
                        }
                        pos++;
                    });
                    cargarListaAgregadoMedicamento();
                });
                
                function cargarListaClientes(){
                    $.get("<c:url value="/findAllCliente"/>",(response)=>{
                        let template = '';
			response.forEach(obj => {
                            template += `
                                <tr rowId="`+obj.id_cliente+`" nombre="`+obj.nombres+`">
                                    <td>`+obj.nombres+`</td>
                                    <td>`+obj.apellidos+`</td>
                                    <td><button class="btnEscogerUsuario btn btn-success">Selecionar</button></td>
                                </tr>
                                `;
                        });
                        $('#lstClientes').html(template);                        
                    });
                }
                
                //Escoger Cliente
                $(document).on('click', '.btnEscogerUsuario', (e) => {
                    const element = $(this)[0].activeElement.parentElement.parentElement;                    
                    const id = $(element).attr('rowId');
                    const nombre = $(element).attr('nombre');
                    $("#txtMostrarCliente").val(nombre);
                    idCliente=id;
                    console.log(idCliente);
                });
                
                //Finalizar Compra
                $("#btnModalGuardar").click(function(){
                                        
                    var jsonData=[];
                        jsonData.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'}); 
                        jsonData.push({name:'id_cliente',value:idCliente});
                        jsonData.push({name:'username',value:'${username}'});
                        jsonData.push({name:"json",value:JSON.stringify(listaProductos)});  
                        console.log(jsonData);
                    $.post("<c:url value="/generarVenta"/>",jsonData,(response)=>{
                         if(response!=null){
                        
                            $("#txtBusqueda").val("");
                            listaProductos=[];
                            idCliente=0;
                            cargarListaAgregadoMedicamento();
                            $("#txtMostrarCliente").val('');
                            $("#precioIgv").html("0000.00");
                            $("#precioSubTotal").html("0000.00");
                            $("#precioTotal").html("0000.00");
                            $("#btnModalFinalizarCerrar").click();
                        }
                    });                    
                    
                });
                
                $("#chbxTipoCliente").click(function(){                    
                    if(!$(this).prop('checked') ){
                        idCliente=0;
                    }
                });
            });
        </script>
    </body>
</html>