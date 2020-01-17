
package pe.senati.dao;

import pe.senati.model.kardexVo;


public interface KardexDao {
    public abstract void insert(kardexVo kardexVo);
    public abstract Integer findStockFindIdProducto(Integer id_producto);
    
    public abstract kardexVo findNewInsert();
}
