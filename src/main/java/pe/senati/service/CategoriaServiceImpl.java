/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.dao.CategoriaDao;
import pe.senati.model.CategoriaVo;

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    @Qualifier("categoriaDaoImpl")
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(CategoriaVo categoriaVo) {
        categoriaDao.insert(categoriaVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(CategoriaVo categoriaVo) {
        categoriaDao.update(categoriaVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_categoria) {
        categoriaDao.delete(id_categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<CategoriaVo> findAll(String Username) {
        return categoriaDao.findAll(Username);
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaVo findById(Integer id_categoria) {
        return categoriaDao.findById(id_categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public String getCodigoTop(String Username) {
        String codigo = categoriaDao.getCodigoTop(Username);
        String iniUsername = Username.substring(0, 2).toUpperCase();
        if(Objects.equals(null, codigo))
            codigo = iniUsername+"C001";
        else
            codigo = iniUsername+"C"+String.format("%03d",(Integer.parseInt(codigo.substring(3))+1));   
        return codigo;
    }
    
}
