/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.RoleVo;
import pe.senati.model.UserVo;
import pe.senati.service.RoleService;
import pe.senati.service.UserService;

@Controller
public class UserController {
    
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Autowired
    @Qualifier("roleServiceImpl")
    private RoleService roleService;
    
    @RequestMapping(value = "/userCrud",method = RequestMethod.GET)
    public String userCrud_get(){
        return "user/userCrud";
    }
    
    @RequestMapping(value = "/findAllUser",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<UserVo> findAllUser_get(){        
        return userService.findAll();
    }
    
    @GetMapping(value = "/findAllRole",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<RoleVo> findAllRole_get(){
        return roleService.findAll();
    }
    
    @PostMapping(value = "/insertUser")    
    @ResponseBody
    public String insertUser_post(UserVo userVo,HttpServletRequest request)throws IOException {                   
        ObjectMapper objectMapper = new ObjectMapper();
        String idRolesJson = request.getParameter("idRolesJson");                
        String[] userVoPrueva = objectMapper.readValue(idRolesJson, String[].class);                    
        Set<RoleVo> itemsRole=new HashSet<>();
        for(String id:userVoPrueva){
            RoleVo roleVo = new RoleVo();
            roleVo.setId_role(Integer.parseInt(id));
            itemsRole.add(roleVo);
        }
        userVo.setItemsRole(itemsRole);                
        userService.insert(userVo);        
        return "OK";        
    }
    
    @PostMapping(value = "/deleteUser")    
    @ResponseBody
    public String eliminarUser_post(HttpServletRequest request){ 
        
        Integer id_user= Integer.parseInt(request.getParameter("id_user"));
        userService.delete(id_user);
        
        return "OK";        
    }
    
    @PostMapping(value = "/updateUser")    
    @ResponseBody
    public String editarUser_post(UserVo userVo){        
        userService.update(userVo);
        return "OK";        
    }
    
    @PostMapping(value = "/findIdUser",produces = MediaType.APPLICATION_JSON_VALUE)    
    @ResponseBody
    public UserVo buscarUser_post(HttpServletRequest request){    
        Integer id_user= Integer.parseInt(request.getParameter("id_user"));
        UserVo userVo=userService.findById(id_user);
        return userVo;        
    }
    
}
