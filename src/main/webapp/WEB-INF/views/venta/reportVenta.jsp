<%-- 
    Document   : reportVenta
    Created on : 30-nov-2019, 14:03:13
    Author     : gian
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/public/bootstrap/css/bootstrap.css" />" rel="stylesheet" media="screen">
        <title>Reporte de Ventas - Sistema</title>
    </head>
    <body>
        <%@include file="../includes/navBar.jsp" %>        
        <div class="row">
            <div class="col-md-2">
                <%@include file="../includes/navHorizontal.jsp" %>  
            </div>
            <div class="col-md-10">
                <h4>Reportes de Ventas</h4>
                <div class="container">                    
                    <div class="row">                
                        <div class="col-md-12" style="overflow: auto; height: 600px;">
                            <table class="table">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>Fecha Venta</th>
                                            <th>Precio Total S/.</th>
                                            <th>Cantidad Productos</th>
                                            <th>Usuario</th>
                                            <th>Ver Detalle</th>
                                        </tr>
                                    </thead>
                                    <tbody id="lstReporte">

                                    </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="modal fade" id="modalDetalle" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                    <div class="modal-dialog modal-lg" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                              <h5 class="modal-title" id="exampleModalLabel">Detalles de Venta</h5>
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                              </button>
                            </div>
                            <div class="modal-body">
                                <div class="container">
                                    <table class="table">
                                        <thead class="thead-light">
                                            <tr>
                                                <th>Nombre</th>
                                                <th>Concentracion</th>
                                                <th>Precio S/.</th>
                                                <th>Camtidad</th>
                                                <th>Precio total S/.</th>
                                            </tr>
                                        </thead>
                                        <tbody id="lstDetalle">

                                        </tbody>
                                    </table>

                                </div>
                            </div>
                            <div class="modal-footer">
                              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>                  
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
                cargarLista();
                
                function cargarLista(){
                    $.get("<c:url value="/findAllVentas"/>",(response)=>{
                        let template = '';
			response.forEach(obj => {
                            var dateEmision = new Date(obj.fecha_emision);
                            var dateRegistroFormat = dateEmision.getDate() + "-" + (dateEmision.getMonth() + 1) + "-" + dateEmision.getFullYear();
                            template += `
                                <tr rowId="`+obj.id_venta+`">
                                    <td>`+dateRegistroFormat+`</td>
                                    <td>`+obj.precio_total+`</td>
                                    <td>`+obj.cantidad_total+`</td>
                                    <td>`+obj.user.username+`</td>
                                    <td><button class="btnDetalle btn btn-warning" data-toggle="modal" data-target="#modalDetalle">Detalles</button></td>
                                </tr>
                                `;
                        });
                        $('#lstReporte').html(template);                        
                    });
                }
                
                $(document).on('click', '.btnDetalle', (e) => {                    
                    const element = $(this)[0].activeElement.parentElement.parentElement;                    
                    const id = $(element).attr('rowId');
                    var jsonData=[];
                        jsonData.push({name:'${_csrf.parameterName}',value:'${_csrf.token}'});
                        jsonData.push({name:'id_venta',value:id});
                    $.post("<c:url value="/findByIdVentas"/>",jsonData,(response)=>{                        
                        let template = '';
			response.forEach(obj => {
                            template += `
                                <tr>
                                    <td>`+obj.id.productoVo.nombre_comercial+`</td>
                                    <td>`+obj.id.productoVo.concentracion+`</td>
                                    <td>`+(obj.precio/obj.cantidad)+`</td>
                                    <td>`+obj.cantidad+`</td>
                                    <td>`+obj.precio+`</td>                                    
                                </tr>
                                `;
                        });
                        $('#lstDetalle').html(template);
                    });
                });
                
            });
            
        </script>
    </body>
</html>
