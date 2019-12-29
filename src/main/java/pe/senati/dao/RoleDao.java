/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.dao;

import java.util.Collection;
import pe.senati.model.RoleVo;

public interface RoleDao {
    
    public abstract RoleVo findById(Integer id_role);
    public abstract RoleVo findByType(String type);    
    public abstract Collection<RoleVo> findAll();
    
}
