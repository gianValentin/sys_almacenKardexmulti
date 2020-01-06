/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.UnidadVo;
import pe.senati.service.UnidadService;

@Controller
public class UnidadController {
    
    @Autowired
    @Qualifier("unidadServiceImpl")
    private UnidadService unidadService;
    
    @GetMapping(value = "/findAllUnidad")
    @ResponseBody
    public Collection<UnidadVo> findAllUnidad(){
        return unidadService.findAll();
    }
}
