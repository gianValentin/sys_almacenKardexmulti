
package pe.senati.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.service.KardexService;

@Controller
public class KardexController {
    
    @Autowired
    @Qualifier("kardexServiceImpl")
    private KardexService kardexService;
    
    @PostMapping(value = "/stockFindProducto")
    @ResponseBody
    public Integer stockFindProducto_post(HttpServletRequest request){
        return kardexService.findStockFindIdProducto(Integer.parseInt(request.getParameter("id_producto")));
    }
        
}
