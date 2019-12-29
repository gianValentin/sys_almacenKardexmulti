/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.senati.dao.UserDao;
import pe.senati.model.UserVo;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    @Qualifier("userDaoImpl")
    private UserDao userDao;
    
    @Override
    @Transactional(readOnly = false)
    public void insert(UserVo userVo) {
        userDao.insert(userVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void update(UserVo userVo) {
        userDao.update(userVo);
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Integer id_user) {
        userDao.delete(id_user);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<UserVo> findAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserVo findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public UserVo findById(Integer id_user) {
        return userDao.findById(id_user);
    }
    
}
