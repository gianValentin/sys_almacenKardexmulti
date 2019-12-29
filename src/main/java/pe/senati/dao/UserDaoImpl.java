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
import pe.senati.model.UserVo;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(UserVo userVo) {
        entityManager.persist(userVo);
    }

    @Override
    public void update(UserVo userVo) {
        entityManager.merge(userVo);
    }

    @Override
    public void delete(Integer id_user) {               
        entityManager.remove(entityManager.find(UserVo.class, id_user));        
    }

    @Override
    public Collection<UserVo> findAll() {
        Query query= entityManager.createNativeQuery("select * from users",UserVo.class);
        return query.getResultList();
    }

    @Override
    public UserVo findByUsername(String username) {
        Query query=entityManager.createNativeQuery("select * from users where username=:param", UserVo.class);
        query.setParameter("param", username);
        return (UserVo)query.getSingleResult();
    }

    @Override
    public UserVo findById(Integer id_user) {
        return entityManager.find(UserVo.class, id_user);
    }
    
}
