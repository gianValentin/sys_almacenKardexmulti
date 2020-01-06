/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import pe.senati.model.UnidadVo;

/**
 *
 * @author gian
 */
public interface UnidadService {
    public abstract void insert(UnidadVo unidad);
    public abstract void update(UnidadVo unidad);
    public abstract void Delete(Integer id_unidad);
    
    public abstract Collection<UnidadVo> findAll();
    public abstract UnidadVo findById(Integer id_unidad);
}
