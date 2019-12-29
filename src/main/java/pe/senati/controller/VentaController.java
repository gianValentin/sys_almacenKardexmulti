/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.ClienteVo;
import pe.senati.model.DetalleVo;
import pe.senati.model.DetalleVo_ID;
import pe.senati.model.JsonDataProductos;
import pe.senati.model.ProductoVo;
import pe.senati.model.UserVo;
import pe.senati.model.VentaVo;
import pe.senati.service.ClienteService;
import pe.senati.service.DetalleService;
import pe.senati.service.ProductoService;
import pe.senati.service.UserService;
import pe.senati.service.VentaService;

@Controller
public class VentaController {
    
    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;
    
    @Autowired
    @Qualifier("ventaServiceImpl")
    private VentaService ventaService;
    
    @Autowired
    @Qualifier("detalleServiceImpl")
    private DetalleService detalleService;
    
    @RequestMapping(value = "/venta",method =RequestMethod.GET)
    public String venta_GET(){        
        return "venta/venta";
    }
    
    @RequestMapping(value = "/reportVenta",method = RequestMethod.GET)
    public String reporteVenta_GET(){
        return "venta/reportVenta";
    }        
    
    @GetMapping(value = "/findAllVentas",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<VentaVo> findAllVentas_GET(){        
        return ventaService.findAll();
    }
    
    @PostMapping(value = "/findByIdVentas",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<DetalleVo> findbyIdVenta_GET(HttpServletRequest request){        
        String id_venta = request.getParameter("id_venta");
        return detalleService.findByIdVenta(Integer.parseInt(id_venta));
    }
    
    @PostMapping(value = "/findByNombre",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<ProductoVo> findByNombre_post(HttpServletRequest request){        
        String nombreBuscar = request.getParameter("txtBusqueda");
        if(nombreBuscar.equals(""))
            nombreBuscar="?";
        return productoService.findByNombre(nombreBuscar);
    }        
    
    @PostMapping(value = "/generarVenta",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<JsonDataProductos> generarVenta_post(HttpServletRequest request) throws IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        //datos de entrada
        String jsonData = request.getParameter("json");        
        String username = request.getParameter("username");
        Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        
        //crear Venta
        ClienteVo clienteVo = null;
        UserVo userVo = userService.findByUsername(username);
        if(id_cliente!=0)
            clienteVo = clienteService.findById(id_cliente);
                
        VentaVo ventaVo = new VentaVo();
        ventaVo.setCliente(clienteVo);
        ventaVo.setUser(userVo);
        ventaVo.setFecha_emision(new Date());        
        ventaService.insert(ventaVo);                                
                
        //pasar json a Colleccion
        Collection<JsonDataProductos> userVoPrueva = objectMapper.readValue(jsonData,new TypeReference<Collection<JsonDataProductos>>(){} );                                    
        
        //crear dettalles
        Float precioTotal = 0.0f;
        Integer cantidadTotal = 0;
        Integer id_Venta=null;
                
        for(JsonDataProductos jsonDataProductos:userVoPrueva){
            Float precioPorProducto = Float.parseFloat(jsonDataProductos.getPrecio()) * Integer.parseInt(jsonDataProductos.getCantidad());
            Integer cantidadPorProducto =Integer.parseInt(jsonDataProductos.getCantidad());            
            cantidadTotal += cantidadPorProducto;
            precioTotal += precioPorProducto;
            
            //pasar datos a detalles
            DetalleVo detalleVo = new DetalleVo();
            detalleVo.setCantidad(cantidadPorProducto);
            detalleVo.setPrecio(precioPorProducto);                        
                                    
            
            ProductoVo productoId = productoService.findById(Integer.parseInt(jsonDataProductos.getId_producto()));            
            //productoId.setId_producto(Integer.parseInt(jsonDataProductos.getId_producto()));
            VentaVo ventaId = ventaService.getlastId();
            id_Venta=ventaId.getId_venta();                        
            
            //agregar Producto y venta
            DetalleVo_ID detalleVo_ID = new DetalleVo_ID();
            detalleVo_ID.setProductoVo(productoId);
            detalleVo_ID.setVentaVo(ventaId);                        
            detalleVo.setId(detalleVo_ID); 
            
            //insertar detalle
            detalleService.insert(detalleVo);
            
            //descontar stock            
            Integer nuevoStock = productoId.getStock()-cantidadPorProducto;
            productoId.setStock(nuevoStock);
            productoService.update(productoId);
            
        }
        
        ventaVo.setId_venta(id_Venta);
        ventaVo.setCantidad_total(cantidadTotal);
        ventaVo.setPrecio_total(precioTotal);
        ventaService.update(ventaVo);
        
        
        return userVoPrueva;
    }
    
}
