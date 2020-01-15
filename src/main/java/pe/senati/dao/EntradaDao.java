
package pe.senati.dao;

import pe.senati.model.EntradaVo;


public interface EntradaDao {
    public abstract void Insert(EntradaVo entradaVo);
    
    public abstract EntradaVo findNewInsert();
}
