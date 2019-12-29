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
        entityManager.remove(entityManager.find(CategoriaVo.class, id_categoria));
    }

    @Override
    public Collection<CategoriaVo> findAll() {
        Query query=entityManager.createNativeQuery("select * from categorias",CategoriaVo.class);
        return query.getResultList();
    }

    @Override
    public CategoriaVo findById(Integer id_categoria) {
        return entityManager.find(CategoriaVo.class, id_categoria);
    }
    
    
    
}
