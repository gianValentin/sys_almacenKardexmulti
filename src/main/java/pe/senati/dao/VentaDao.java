/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;

import java.util.Collection;
import pe.senati.model.VentaVo;

/**
 *
 * @author gian
 */
public interface VentaDao {
    public abstract void insert(VentaVo ventaVo);
    public abstract void update(VentaVo ventaVo);
    
    public abstract VentaVo findById(Integer id_venta);
    public abstract Collection<VentaVo> findAll();
    public abstract VentaVo getlastId();
}
