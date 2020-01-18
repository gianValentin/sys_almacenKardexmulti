
package pe.senati.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import pe.senati.model.Detalle_Entrada_ID;
import pe.senati.model.EntradaVo;
import pe.senati.model.ProductoVo;
import pe.senati.model.jsonDetalleEntrada;
import pe.senati.model.kardexVo;
import pe.senati.service.Detalle_EntradaService;
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
    
    @Autowired
    @Qualifier("detalle_EntradaServiceImpl")
    private Detalle_EntradaService detalle_EntradaService;
    
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
        //CREAR ENTRADA
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
            
            kardexVo.setPrecio_venta(json.getPrecio());
            
            //CREAR KARDEX
            kardexService.insert(kardexVo);   
            kardexVo = kardexService.findNewInsert();
            
            // CREAR EL IDs DETALLE
            Detalle_Entrada_ID detalle_Entrada_Id = new Detalle_Entrada_ID();
            detalle_Entrada_Id.setEntradaVo(entradaVo);
            detalle_Entrada_Id.setKardexVo(kardexVo);
            
            //CREAR DETALLE
            Detalle_EntradaVo detalle_Entrada = new Detalle_EntradaVo();
            detalle_Entrada.setCantidad(json.getCantidad());
            detalle_Entrada.setPrecio(json.getPrecio());
            detalle_Entrada.setId(detalle_Entrada_Id);            
            detalle_EntradaService.insert(detalle_Entrada);
            
        }            
        
        return true;
    }
        
}
