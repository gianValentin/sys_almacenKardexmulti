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
import pe.senati.model.TipoVo;
import pe.senati.service.TipoService;

@Controller
public class PresentacionController {
    
    @Autowired
    @Qualifier("tipoServiceImpl")
    private TipoService tipoService;
    
    @RequestMapping(value = "/tipoCrud",method = RequestMethod.GET)
    public String presentacionCrud_get(){
        return "tipo/tipoCrud";
    }
    
    @RequestMapping(value = "/findAllTipo",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<TipoVo> findAllCategoria_get(){        
        return tipoService.findAll();
    }    
    
}
