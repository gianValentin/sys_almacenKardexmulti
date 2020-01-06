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
import pe.senati.model.TipoVo;

@Repository
public class TipoDaoImpl implements TipoDao{
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insert(TipoVo tipoVo) {
        entityManager.persist(tipoVo);
    }

    @Override
    public void update(TipoVo tipoVo) {
        entityManager.merge(tipoVo);
    }

    @Override
    public void delete(Integer id_tipo) {
        Query query = entityManager.createNativeQuery("update tipos set status='DELETE' where id_categoria=:param", TipoVo.class);
        query.setParameter("param", id_tipo);        
        query.executeUpdate();
    }

    @Override
    public Collection<TipoVo> findAll() {
        Query query = entityManager.createNativeQuery("select * from tipos where status!='DELETE'",TipoVo.class);
        return query.getResultList();
    }

    @Override
    public TipoVo findById(Integer id_tipo) {
        return entityManager.find(TipoVo.class, id_tipo);
    }
    
}
