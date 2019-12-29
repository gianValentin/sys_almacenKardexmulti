/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.controller;

import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.PresentacionVo;
import pe.senati.service.PresentacionService;

@Controller
public class PresentacionController {
    
    @Autowired
    @Qualifier("presentacionServiceImpl")
    private PresentacionService presentacionService;
    
    @RequestMapping(value = "/presentacionCrud",method = RequestMethod.GET)
    public String presentacionCrud_get(){
        return "presentacion/presentacionCrud";
    }
    
    @RequestMapping(value = "/findAllPresentacion",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<PresentacionVo> findAllCategoria_get(){        
        return presentacionService.findAll();
    }
    
    @PostMapping(value = "/insertPresentacion")    
    @ResponseBody
    public String insertPresentacion_post(HttpServletRequest request){        
        PresentacionVo prsentacioVo=new PresentacionVo();           
        prsentacioVo.setPresentacion(request.getParameter("presentacion"));        
        presentacionService.insert(prsentacioVo);
        return "OK";        
    }
    
    @PostMapping(value = "/deletePresentacion")    
    @ResponseBody
    public String eliminarPresentacion_post(HttpServletRequest request){    
        Integer id_presentacion= Integer.parseInt(request.getParameter("id_presentacion"));
        presentacionService.delete(id_presentacion);
        return "OK";        
    }
    
    @PostMapping(value = "/updatePresentacion")    
    @ResponseBody
    public String editarPresentacion_post(HttpServletRequest request){
        PresentacionVo categoriaVo=new PresentacionVo();     
        categoriaVo.setId_presentacion(Integer.parseInt(request.getParameter("id_presentacion")));
        categoriaVo.setPresentacion(request.getParameter("presentacion"));        
        presentacionService.update(categoriaVo);
        return "OK";        
    }
    
    @PostMapping(value = "/findIdPresentacion",produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public PresentacionVo buscarPresentacion_post(HttpServletRequest request){    
        Integer id_presentacion= Integer.parseInt(request.getParameter("id_presentacion"));
        PresentacionVo categoriaVo=presentacionService.findById(id_presentacion);
        return categoriaVo;        
    }
    
}
