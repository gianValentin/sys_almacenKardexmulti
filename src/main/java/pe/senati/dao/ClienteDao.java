/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;

import java.util.Collection;
import pe.senati.model.ClienteVo;


public interface ClienteDao {
        
    public abstract void insert(ClienteVo clienteVo);
    public abstract void update(ClienteVo clienteVo);
    public abstract void delete(Integer id_cliente);
    
    public abstract Collection<ClienteVo> findAll();
    public abstract ClienteVo findById(Integer id_cliente);
}
