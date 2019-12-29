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
import pe.senati.model.ClienteVo;

@Repository
public class ClienteDaoImpl implements ClienteDao{

    @PersistenceContext
    private EntityManager entityManager;
    
    @Override
    public void insert(ClienteVo clienteVo) {
        entityManager.persist(clienteVo);
    }

    @Override
    public void update(ClienteVo clienteVo) {
        entityManager.merge(clienteVo);
    }

    @Override
    public void delete(Integer id_cliente) {
        entityManager.remove(entityManager.find(ClienteVo.class, id_cliente));
    }

    @Override
    public Collection<ClienteVo> findAll() {
        Query query= entityManager.createNativeQuery("select * from clientes",ClienteVo.class);
        return query.getResultList();
    }

    @Override
    public ClienteVo findById(Integer id_cliente) {
        return entityManager.find(ClienteVo.class, id_cliente);
    }
    
}
