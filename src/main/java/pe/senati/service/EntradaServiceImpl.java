/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.dao.EntradaDao;
import pe.senati.model.EntradaVo;

@Service
public class EntradaServiceImpl implements EntradaService{

    @Autowired
    @Qualifier("entradaDaoImpl")
    private EntradaDao entradaDao;
    
    @Override
    @Transactional(readOnly = true)
    public void Insert(EntradaVo entradaVo) {
        entradaDao.Insert(entradaVo);
    }

    @Override
    @Transactional(readOnly = false)
    public EntradaVo findNewInsert() {
        return entradaDao.findNewInsert();
    }
    
}
