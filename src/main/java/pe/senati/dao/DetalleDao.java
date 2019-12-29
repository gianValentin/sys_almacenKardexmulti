/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;

import java.util.Collection;
import pe.senati.model.DetalleVo;

/**
 *
 * @author gian
 */
public interface DetalleDao {
    public abstract void insert(DetalleVo detalleVo);
    public abstract Collection<DetalleVo> findByIdVenta(Integer id_venta);
}
