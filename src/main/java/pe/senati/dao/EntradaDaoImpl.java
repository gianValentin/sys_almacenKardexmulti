
package pe.senati.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.senati.model.EntradaVo;

@Repository
public class EntradaDaoImpl implements EntradaDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void Insert(EntradaVo entradaVo) {
        entityManager.persist(entradaVo);
    }

    @Override
    public EntradaVo findNewInsert() {
        Query query = entityManager.createNativeQuery("select * from entradas order by id_entradaM desc limit 1",EntradaVo.class);
        return (EntradaVo)query.getSingleResult();
    }
    
}
