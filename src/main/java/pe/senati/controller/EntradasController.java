
package pe.senati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EntradasController {
    
    @GetMapping(value = "/entrada")
    public String entradaMercaderia_get(){
        return "/kardex/entrada";
    }
    
}
