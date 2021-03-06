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
import pe.senati.dao.ProductoDao;
import pe.senati.model.ProductoVo;

@Service
public class ProductoServiceImpl implements ProductoService{

    @Autowired
    @Qualifier("productoDaoImpl")
    private ProductoDao productoDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(ProductoVo productoVo) {
        productoDao.insert(productoVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(ProductoVo productoVo) {
        productoDao.update(productoVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_producto) {
        productoDao.delete(id_producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ProductoVo> findAll(String Username) {
        return productoDao.findAll(Username);
    }

    @Override
    @Transactional(readOnly = false)
    public ProductoVo findById(Integer id_producto) {
        return productoDao.findById(id_producto);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ProductoVo> findByNombre(String nombre) {
        return productoDao.findByNombre(nombre);
    }

    @Override
    @Transactional(readOnly = true)
    public String getCodigoTop(String Username) {
        String codigo = productoDao.getCodigoTop(Username);
        
        String iniUsername = Username.substring(0, 2).toUpperCase();
        if(Objects.equals(null, codigo))
            codigo = iniUsername+"P0001";
       else
            codigo = iniUsername+"P"+String.format("%04d",(Integer.parseInt(codigo.substring(3))+1));   
        return codigo;
    }
       
}
