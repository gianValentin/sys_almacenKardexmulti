/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;

import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import pe.senati.model.CategoriaVo;
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
        Query query = entityManager.createNativeQuery("update productos set status='DELETE' where id_producto=:param", ProductoVo.class);
        query.setParameter("param", id_producto);        
        query.executeUpdate();
    }

    @Override
    public Collection<ProductoVo> findAll(String Username) {
        String consulta="select p.* from productos p " +
                        "inner join categorias c on c.id_categoria = p.id_categoria " +
                        "inner join users u on u.id_user = c.id_user "+
                        "where p.status!='DELETE' and u.username =:param";
        Query query = entityManager.createNativeQuery(consulta, ProductoVo.class);
        query.setParameter("param", Username);
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

    @Override
    public String getCodigoTop(String Username) {
        String consulta="select p.codigo_producto from productos p " +
                        "inner join categorias c on c.id_categoria = p.id_categoria " +
                        "inner join users u on u.id_user = c.id_user " +
                        "where u.username =:param " +
                        "order by p.codigo_producto desc limit 1";
        
        Query query = entityManager.createNativeQuery(consulta);
        query.setParameter("param", Username);
        String codigo=null;
        try{
            codigo = (String)query.getSingleResult();
        }catch(NoResultException ex){
        }
        return codigo;
    }
    
}
