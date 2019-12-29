/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import pe.senati.model.CategoriaVo;

/**
 *
 * @author gian
 */
public interface CategoriaService {
    public abstract void insert(CategoriaVo categoriaVo);
    public abstract void update(CategoriaVo categoriaVo);
    public abstract void delete(Integer id_categoria);
    
    public abstract Collection<CategoriaVo> findAll();
    public abstract CategoriaVo findById(Integer id_categoria);
}
