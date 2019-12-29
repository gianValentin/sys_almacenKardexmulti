/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.dao.ClienteDao;
import pe.senati.model.ClienteVo;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    @Qualifier("clienteDaoImpl")
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = false)
    public void insert(ClienteVo clienteVo) {
        clienteDao.insert(clienteVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(ClienteVo clienteVo) {
        clienteDao.update(clienteVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_cliente) {
        clienteDao.delete(id_cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ClienteVo> findAll() {
        return clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ClienteVo findById(Integer id_cliente) {
        return clienteDao.findById(id_cliente);
    }
    
}
