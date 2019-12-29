/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import pe.senati.model.ProductoVo;


public interface ProductoService {
    
    public abstract void insert(ProductoVo productoVo);
    public abstract void update(ProductoVo productoVo);
    public abstract void delete(Integer id_producto);
    
    public abstract Collection<ProductoVo> findAll();
    public abstract Collection<ProductoVo> findByNombre(String nombre);
    public abstract ProductoVo findById(Integer id_producto);
}
