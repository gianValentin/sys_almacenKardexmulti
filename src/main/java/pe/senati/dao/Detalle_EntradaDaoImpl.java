
package pe.senati.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import pe.senati.model.Detalle_EntradaVo;

@Repository
public class Detalle_EntradaDaoImpl implements Detalle_EntradaDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(Detalle_EntradaVo detalle_EntradaVo) {
        entityManager.persist(detalle_EntradaVo);
    }
    
}
