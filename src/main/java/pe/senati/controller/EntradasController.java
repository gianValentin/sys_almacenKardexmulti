
package pe.senati.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.awt.ItemSelectable;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pe.senati.model.Detalle_EntradaVo;
import pe.senati.model.EntradaVo;
import pe.senati.model.ProductoVo;
import pe.senati.model.jsonDetalleEntrada;
import pe.senati.model.kardexVo;
import pe.senati.service.EntradaService;
import pe.senati.service.KardexService;

@Controller
public class EntradasController {
    
    @Autowired
    @Qualifier("kardexServiceImpl")
    private KardexService kardexService;
    
    @Autowired
    @Qualifier("entradaServiceImpl")
    private EntradaService entradaService;
    
    @GetMapping(value = "/entrada")
    public String entradaMercaderia_get(){
        return "/kardex/entrada";
    }
    
    @PostMapping(value = "/createEntrada")
    @ResponseBody
    public Boolean createEntrada_post(EntradaVo entradaVo,HttpServletRequest request) throws IOException{
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        //pasar json a Colleccion
        Collection<jsonDetalleEntrada> detalles = objectMapper.readValue(request.getParameter("json"),new TypeReference<Collection<jsonDetalleEntrada>>(){} );                                    
        //crear entrada
        entradaService.Insert(entradaVo);
        entradaVo = entradaService.findNewInsert();
        
        for(jsonDetalleEntrada json : detalles){
            
            Integer id_producto = json.getId_producto();
            Integer stock_anterior=kardexService.findStockFindIdProducto(id_producto);
            
            ProductoVo productoVo = new ProductoVo();
            productoVo.setId_producto(id_producto);
            
            //crear Kardex
            kardexVo kardexVo = new kardexVo();
            kardexVo.setProducto(productoVo);
            kardexVo.setStock_anterior(stock_anterior);
            kardexVo.setStock_actual(stock_anterior+json.getCantidad());           
            
            
           /* Detalle_EntradaVo detalle_Entrada = new Detalle_EntradaVo();
            detalle_Entrada.setCantidad();
            detalle_Entrada.setPrecio(Double.NaN);
            
            Set<Detalle_EntradaVo> itemsDetalle = new HashSet<>();
            itemsDetalle.add();
            
            kardexVo.setItemsDetalle(itemsDetalle);*/
            
            kardexService.insert(kardexVo);                                    
            
        }
            
        
        return true;
    }
        
}
