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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.ClienteVo;
import pe.senati.service.ClienteService;

@Controller
public class ClienteController {
    
    @Autowired
    @Qualifier("clienteServiceImpl")
    private ClienteService clienteService;
    
    @RequestMapping(value = "/clienteCrud",method = RequestMethod.GET)
    public String clienteCrud_get(){
        return "cliente/clienteCrud";
    }        
    
    @RequestMapping(value = "/findAllCliente",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<ClienteVo> findAllCliente_get(){        
        return clienteService.findAll();
    }
    
    
    @PostMapping(value = "/insertCliente")    
    @ResponseBody
    public String insertCliente_post(ClienteVo clienteVo){                                
        clienteService.insert(clienteVo);        
        return "OK";        
    }
    
    @PostMapping(value = "/deleteCliente")    
    @ResponseBody
    public String eliminarCliente_post(HttpServletRequest request){ 
        
        Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        clienteService.delete(id_cliente);
        
        return "OK";        
    }
    
    @PostMapping(value = "/updateCliente")    
    @ResponseBody
    public String editarCliente_post(ClienteVo clienteVo){        
        clienteService.update(clienteVo);
        return "OK";        
    }
    
    @PostMapping(value = "/findIdCliente",produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public ClienteVo buscarCliente_post(HttpServletRequest request){    
        Integer id_cliente = Integer.parseInt(request.getParameter("id_cliente"));
        ClienteVo clienteVo=clienteService.findById(id_cliente);
        return clienteVo;        
    }
    
}
