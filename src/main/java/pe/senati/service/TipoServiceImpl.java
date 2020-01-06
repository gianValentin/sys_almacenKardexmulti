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
import pe.senati.dao.TipoDao;
import pe.senati.model.TipoVo;

@Service
public class TipoServiceImpl implements TipoService{

    @Autowired
    @Qualifier("tipoDaoImpl")
    private TipoDao tipoDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(TipoVo tipoVo) {
        tipoDao.insert(tipoVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(TipoVo tipoVo) {
        tipoDao.update(tipoVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_tipo) {
        tipoDao.delete(id_tipo);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<TipoVo> findAll() {
        return tipoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoVo findById(Integer id_tipo) {
        return tipoDao.findById(id_tipo);
    }
    
}
