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
import pe.senati.dao.RoleDao;
import pe.senati.model.RoleVo;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    @Qualifier("roleDaoImpl")
    private RoleDao roleDao;
    
    @Override
    @Transactional(readOnly = true)
    public RoleVo findById(Integer id_role) {
        return roleDao.findById(id_role);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleVo findByType(String type) {
        return roleDao.findByType(type);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<RoleVo> findAll() {
        return roleDao.findAll();
    }
    
}
