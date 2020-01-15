
package pe.senati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.dao.KardexDao;
import pe.senati.model.kardexVo;

@Service
public class KardexServiceImpl implements KardexService{

    @Autowired
    @Qualifier("kardexDaoImpl")
    private KardexDao kardexDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(kardexVo kardexVo) {
        kardexDao.insert(kardexVo);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Integer findStockFindIdProducto(Integer id_producto) {
        return kardexDao.findStockFindIdProducto(id_producto);
    }   
    
}
