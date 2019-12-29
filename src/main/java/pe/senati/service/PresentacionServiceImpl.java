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
import pe.senati.dao.PresentacionDao;
import pe.senati.model.PresentacionVo;

@Service
public class PresentacionServiceImpl implements PresentacionService{

    @Autowired
    @Qualifier("presentacionDaoImpl")
    private PresentacionDao presentacionDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(PresentacionVo presentacionVo) {
        presentacionDao.insert(presentacionVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(PresentacionVo presentacionVo) {
        presentacionDao.update(presentacionVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_presentacion) {
        presentacionDao.delete(id_presentacion);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<PresentacionVo> findAll() {
        return presentacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public PresentacionVo findById(Integer id_presentacion) {
        return presentacionDao.findById(id_presentacion);
    }
    
}
