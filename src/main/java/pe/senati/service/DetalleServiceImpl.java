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
import pe.senati.dao.DetalleDao;
import pe.senati.model.DetalleVo;

@Service
public class DetalleServiceImpl implements DetalleService{

    @Autowired
    @Qualifier("detalleDaoImpl")
    private DetalleDao detalleDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(DetalleVo detalleVo) {
        detalleDao.insert(detalleVo);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<DetalleVo> findByIdVenta(Integer id_venta) {
        return detalleDao.findByIdVenta(id_venta);
    }
    
}
