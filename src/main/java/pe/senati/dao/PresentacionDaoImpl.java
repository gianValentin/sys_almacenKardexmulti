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
import pe.senati.model.PresentacionVo;

@Repository
public class PresentacionDaoImpl implements PresentacionDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(PresentacionVo presentacionVo) {
        entityManager.persist(presentacionVo);
    }

    @Override
    public void update(PresentacionVo presentacionVo) {
        entityManager.merge(presentacionVo);
    }

    @Override
    public void delete(Integer id_presentacion) {
        entityManager.remove(entityManager.find(PresentacionVo.class, id_presentacion));
    }

    @Override
    public Collection<PresentacionVo> findAll() {
        Query query = entityManager.createNativeQuery("select * from presentaciones",PresentacionVo.class);
        return query.getResultList();
    }

    @Override
    public PresentacionVo findById(Integer id_presentacion) {
        return entityManager.find(PresentacionVo.class, id_presentacion);
    }
    
}
