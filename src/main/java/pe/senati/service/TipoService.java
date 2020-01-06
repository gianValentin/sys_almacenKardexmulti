/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import pe.senati.model.TipoVo;

/**
 *
 * @author gian
 */
public interface TipoService {
    public abstract void insert(TipoVo tipoVo);
    public abstract void update(TipoVo tipoVo);
    public abstract void delete(Integer id_tipo);
    
    public abstract Collection<TipoVo> findAll();
    public abstract TipoVo findById(Integer id_tipo);    
}
