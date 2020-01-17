
package pe.senati.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SalidasController {
    
    @GetMapping(value = "/salida")
    public String SalidaMercaderia_get(){
        return "kardex/salida";
    }
    
}
