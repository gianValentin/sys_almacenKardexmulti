/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import pe.senati.model.UserVo;

public interface UserService {
    public abstract void insert(UserVo userVo);
    public abstract void update(UserVo userVo);
    public abstract void delete(Integer id_user);
    
    public abstract UserVo findByUsername(String username);    
    public abstract UserVo findById(Integer id_user);
    public abstract Collection<UserVo> findAll();
}
