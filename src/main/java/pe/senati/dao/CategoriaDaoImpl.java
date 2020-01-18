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
import pe.senati.model.CategoriaVo;

@Repository
public class CategoriaDaoImpl implements CategoriaDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(CategoriaVo categoriaVo) {
        entityManager.persist(categoriaVo);
    }

    @Override
    public void update(CategoriaVo categoriaVo) {
        entityManager.merge(categoriaVo);
    }

    @Override
    public void delete(Integer id_categoria) {
        Query query = entityManager.createNativeQuery("update categorias set status='DELETE' where id_categoria=:param", CategoriaVo.class);
        query.setParameter("param", id_categoria);        
        query.executeUpdate();
    }

    @Override
    public Collection<CategoriaVo> findAll(String Username) {
        String consulta="select c.* from categorias c " +                        
                        "inner join users u on u.id_user = c.id_user "+
                        "where c.status!='DELETE' and u.username =:param";
        Query query=entityManager.createNativeQuery(consulta,CategoriaVo.class);
        query.setParameter("param", Username);
        return query.getResultList();
    }

    @Override
    public CategoriaVo findById(Integer id_categoria) {
        return entityManager.find(CategoriaVo.class, id_categoria);
    }
    
    
    
}
