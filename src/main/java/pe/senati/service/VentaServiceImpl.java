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
import pe.senati.dao.VentaDao;
import pe.senati.model.VentaVo;

@Service
public class VentaServiceImpl implements VentaService{
    
    @Autowired
    @Qualifier("ventaDaoImpl")
    private VentaDao ventaDao;

    @Override
    @Transactional(readOnly = false)
    public void insert(VentaVo ventaVo) {
        ventaDao.insert(ventaVo);
    }
    
    @Override
    @Transactional(readOnly = false)
    public void update(VentaVo ventaVo) {
        ventaDao.update(ventaVo);
    }

    @Override
    @Transactional(readOnly = true)
    public VentaVo findById(Integer id_venta) {
        return ventaDao.findById(id_venta);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<VentaVo> findAll() {
        return ventaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public VentaVo getlastId() {
        return ventaDao.getlastId();
    }
    
}
