/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;


import java.util.Collection;
import pe.senati.model.PresentacionVo;

public interface PresentacionDao {
    public abstract void insert(PresentacionVo presentacionVo);
    public abstract void update(PresentacionVo presentacionVo);
    public abstract void delete(Integer id_presentacion);
    
    public abstract Collection<PresentacionVo> findAll();
    public abstract PresentacionVo findById(Integer id_presentacion);    
}
