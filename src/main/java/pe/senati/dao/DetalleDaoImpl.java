/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import pe.senati.model.DetalleVo;

@Repository
public class DetalleDaoImpl implements DetalleDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(DetalleVo detalleVo) {
        entityManager.persist(detalleVo);
    }

    @Override
    public Collection<DetalleVo> findByIdVenta(Integer id_venta) {
        Query query = entityManager.createNativeQuery("select * from detalles where id_venta=:param", DetalleVo.class);
        query.setParameter("param", id_venta);
        return query.getResultList();
    }
    
}
