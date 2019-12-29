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
import pe.senati.model.ProductoVo;

@Repository
public class ProductoDaoImpl implements ProductoDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(ProductoVo productoVo) {
        entityManager.persist(productoVo);
    }

    @Override
    public void update(ProductoVo productoVo) {
        entityManager.merge(productoVo);
    }

    @Override
    public void delete(Integer id_producto) {
        entityManager.remove(entityManager.find(ProductoVo.class, id_producto));
    }

    @Override
    public Collection<ProductoVo> findAll() {
        Query query = entityManager.createNativeQuery("select * from productos", ProductoVo.class);
        return query.getResultList();
    }

    @Override
    public ProductoVo findById(Integer id_producto) {
        return entityManager.find(ProductoVo.class, id_producto);
    }

    @Override
    public Collection<ProductoVo> findByNombre(String nombre) {
        Query query = entityManager.createNativeQuery("select * from productos where nombre_comercial like :param1 or nombre_generico like :param2", ProductoVo.class);
        query.setParameter("param1", nombre+"%");
        query.setParameter("param2", nombre+"%");
        return query.getResultList();
    }
    
}
