
package pe.senati.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.dao.Detalle_EntradaDao;
import pe.senati.model.Detalle_EntradaVo;

@Service
public class Detalle_EntradaServiceImpl implements Detalle_EntradaService{
    
    @Autowired
    @Qualifier("detalle_EntradaDaoImpl")
    private Detalle_EntradaDao detalle_EntradaDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(Detalle_EntradaVo detalle_EntradaVo) {
        detalle_EntradaDao.insert(detalle_EntradaVo);
    }
    
}
