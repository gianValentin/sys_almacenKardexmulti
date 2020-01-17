
package pe.senati.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import pe.senati.model.kardexVo;

@Repository
public class KardexDaoImpl implements KardexDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public Integer findStockFindIdProducto(Integer id_producto) {
        Query query = entityManager.createNativeQuery("select stock_actual from kardex where id_producto=:param order by id_kardex desc limit 1;");
        query.setParameter("param", id_producto);
        Integer stock = 0;
        try{
            stock = (Integer)query.getSingleResult();
        }catch(NoResultException ex){
        }
        return stock;
    }

    @Override
    public void insert(kardexVo kardexVo) {
        entityManager.persist(kardexVo);
    }

    @Override
    public kardexVo findNewInsert() {
        Query query = entityManager.createNativeQuery("select * from kardex order by id_kardex desc limit 1",kardexVo.class);
        return (kardexVo)query.getSingleResult();
    }
    
}
