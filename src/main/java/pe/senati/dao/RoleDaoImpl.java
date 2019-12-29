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
import pe.senati.model.RoleVo;

@Repository
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public RoleVo findById(Integer id_role) {
        return entityManager.find(RoleVo.class, id_role);
    }

    @Override
    public RoleVo findByType(String type) {
        Query query=entityManager.createNativeQuery("select * from roles where id_role=:param", RoleVo.class);
        query.setParameter("param", type);
        return (RoleVo)query.getSingleResult();
    }

    @Override
    public Collection<RoleVo> findAll() {
        Query query=entityManager.createNativeQuery("select * from roles", RoleVo.class);        
        return query.getResultList();
    }
    
    
}
