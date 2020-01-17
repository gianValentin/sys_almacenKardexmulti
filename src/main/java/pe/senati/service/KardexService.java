
package pe.senati.service;

import pe.senati.model.kardexVo;


public interface KardexService {
    public abstract void insert(kardexVo kardexVo);
    public abstract Integer findStockFindIdProducto(Integer id_producto);
    
    public abstract kardexVo findNewInsert();
}
