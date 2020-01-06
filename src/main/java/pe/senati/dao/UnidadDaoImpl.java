
package pe.senati.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.senati.model.UnidadVo;

@Repository
public class UnidadDaoImpl implements UnidadDao{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(UnidadVo unidad) {
        entityManager.persist(unidad);
    }

    @Override
    public void update(UnidadVo unidad) {
        entityManager.merge(unidad);
    }

    @Override
    public void Delete(Integer id_unidad) {
        Query query = entityManager.createNativeQuery("update unidades set status='DELETE' where id_categoria=:param", UnidadVo.class);
        query.setParameter("param", id_unidad);        
        query.executeUpdate();
    }

    @Override
    public Collection<UnidadVo> findAll() {
        Query query = entityManager.createNativeQuery("select * from unidades where status!='DELETE'", UnidadVo.class);
        return query.getResultList();
    }

    @Override
    public UnidadVo findById(Integer id_unidad) {
        return entityManager.find(UnidadVo.class, id_unidad);
    }
    
}
