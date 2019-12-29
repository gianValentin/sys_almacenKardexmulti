/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.controller;

import java.util.Collection;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.CategoriaVo;
import pe.senati.model.PresentacionVo;
import pe.senati.model.ProductoVo;
import pe.senati.service.ProductoService;

@Controller
public class ProductoController {
    
    @Autowired
    @Qualifier("productoServiceImpl")
    private ProductoService productoService;
    
    @RequestMapping(value = "/productoCrud",method = RequestMethod.GET)
    public String productoCrud_get(){
        return "producto/productoCrud";
    }
    
    @RequestMapping(value = "/findAllProducto",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<ProductoVo> findAllProducto_get(){
        
        return productoService.findAll();
    }
    
    @PostMapping(value = "/insertProducto",produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public ProductoVo insertProducto_post(ProductoVo producto,HttpServletRequest request){                    
        
        PresentacionVo presentacionVo = new PresentacionVo();
        CategoriaVo categoriaVo = new CategoriaVo();
        
        presentacionVo.setId_presentacion(Integer.parseInt(request.getParameter("id_presentacion")));
        categoriaVo.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
        
        producto.setPresentacion(presentacionVo);
        producto.setCategoria(categoriaVo);
        producto.setFecha_registro(new Date());        
        
        productoService.insert(producto);
        
        return producto;        
    }
    
    @PostMapping(value = "/deleteProducto")    
    @ResponseBody
    public String eliminarProducto_post(HttpServletRequest request){ 
        
        Integer id_producto= Integer.parseInt(request.getParameter("id_producto"));
        productoService.delete(id_producto);
        
        return "OK";        
    }
    
    @PostMapping(value = "/updateProducto")    
    @ResponseBody
    public String editarProducto_post(ProductoVo productoVo,HttpServletRequest request){

        PresentacionVo presentacionVo = new PresentacionVo();
        CategoriaVo categoriaVo = new CategoriaVo();
        
        presentacionVo.setId_presentacion(Integer.parseInt(request.getParameter("id_presentacion")));
        categoriaVo.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
        
        productoVo.setPresentacion(presentacionVo);
        productoVo.setCategoria(categoriaVo);
        
        productoService.update(productoVo);
        return "OK";        
    }
    
    @PostMapping(value = "/findIdProducto",produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public ProductoVo buscarProducto_post(HttpServletRequest request){    
        Integer id_producto= Integer.parseInt(request.getParameter("id_producto"));
        ProductoVo productoVo=productoService.findById(id_producto);
        return productoVo;        
    }
    
}
