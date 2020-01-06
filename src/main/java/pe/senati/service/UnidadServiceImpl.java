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
import pe.senati.dao.UnidadDao;
import pe.senati.model.UnidadVo;

@Service
public class UnidadServiceImpl implements UnidadService{

    @Autowired
    @Qualifier("unidadDaoImpl")
    private UnidadDao unidadDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(UnidadVo unidad) {
        unidadDao.insert(unidad);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(UnidadVo unidad) {
        unidadDao.update(unidad);
    }

    @Override
    @Transactional(readOnly = false)
    public void Delete(Integer id_unidad) {
        unidadDao.Delete(id_unidad);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<UnidadVo> findAll() {
        return unidadDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UnidadVo findById(Integer id_unidad) {
        return unidadDao.findById(id_unidad);
    }
    
}
