
package pe.senati.dao;

import java.util.Collection;
import pe.senati.model.UnidadVo;


public interface UnidadDao {
    public abstract void insert(UnidadVo unidad);
    public abstract void update(UnidadVo unidad);
    public abstract void Delete(Integer id_unidad);
    
    public abstract Collection<UnidadVo> findAll();
    public abstract UnidadVo findById(Integer id_unidad);
}
