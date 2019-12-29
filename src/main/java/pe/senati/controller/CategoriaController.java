/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.controller;

import java.util.Collection;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.CategoriaVo;
import pe.senati.service.CategoriaService;

@Controller
public class CategoriaController {
    
    
    @Autowired
    @Qualifier("categoriaServiceImpl")
    private CategoriaService categoriaService;
    
    
    @RequestMapping(value = "/categoriaCrud",method = RequestMethod.GET)
    public String categoriaCrud_get(){
        return "categoria/categoriaCrud";
    }
    
    @RequestMapping(value = "/findAllCategoria",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<CategoriaVo> findAllCategoria_get(){
        
        return categoriaService.findAll();
    }
    
    @PostMapping(value = "/insertCategoria")    
    @ResponseBody
    public String insertCategoria_post(HttpServletRequest request){        
        CategoriaVo categoriaVo=new CategoriaVo();           
        categoriaVo.setCategoria(request.getParameter("categoria"));
        categoriaVo.setDescripcion(request.getParameter("descripcion"));
        categoriaService.insert(categoriaVo);
        return "OK";        
    }
    
    @PostMapping(value = "/deleteCategoria")    
    @ResponseBody
    public String eliminarCategoria_post(HttpServletRequest request){    
        Integer id_categoria= Integer.parseInt(request.getParameter("id_categoria"));
        categoriaService.delete(id_categoria);
        return "OK";        
    }
    
    @PostMapping(value = "/updateCategoria")    
    @ResponseBody
    public String editarCategoria_post(HttpServletRequest request){
        CategoriaVo categoriaVo=new CategoriaVo();     
        categoriaVo.setId_categoria(Integer.parseInt(request.getParameter("id_categoria")));
        categoriaVo.setCategoria(request.getParameter("categoria"));
        categoriaVo.setDescripcion(request.getParameter("descripcion"));
        categoriaService.update(categoriaVo);
        return "OK";        
    }
    
    @PostMapping(value = "/findIdCategoria",produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public CategoriaVo buscarCategoria_post(HttpServletRequest request){    
        Integer id_categoria= Integer.parseInt(request.getParameter("id_categoria"));
        CategoriaVo categoriaVo=categoriaService.findById(id_categoria);
        return categoriaVo;        
    }
    
}
