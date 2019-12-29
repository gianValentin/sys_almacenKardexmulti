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
import org.springframework.stereotype.Repository;
import pe.senati.model.VentaVo;

@Repository
public class VentaDaoImpl implements VentaDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(VentaVo ventaVo) {
        entityManager.persist(ventaVo);
    }
    
    @Override
    public void update(VentaVo ventaVo) {
        entityManager.merge(ventaVo);
    }

    @Override
    public VentaVo findById(Integer id_venta) {
        return entityManager.find(VentaVo.class, id_venta);
    }

    @Override
    public Collection<VentaVo> findAll() {
        Query query = entityManager.createNativeQuery("select * from ventas order by id_venta desc", VentaVo.class);
        return query.getResultList();
    }

    @Override
    public VentaVo getlastId() {
        Query query = entityManager.createNativeQuery("select * from ventas order by id_venta desc limit 1", VentaVo.class);
        return (VentaVo)query.getSingleResult();
    }    
    
}
