/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.service;

import java.util.ArrayList;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.senati.model.RoleVo;
import pe.senati.model.UserVo;

@Service
public class UserServiceDetailsImpl implements UserDetailsService{

    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserVo user = userService.findByUsername(username);
        if(user!=null){
            
            //colleccion roels (Vacio)
            Collection<GrantedAuthority> roles=new ArrayList<>();
            for(RoleVo role:user.getItemsRole()){
                roles.add(new SimpleGrantedAuthority("ROLE_"+role.getType()));
            }
            
            return new User(
                    user.getUsername(), 
                    user.getPassword(), 
                    user.getEstado().equals("ACTIVE"), 
                    true, true, true, 
                    roles);
        }
        throw new UsernameNotFoundException("error, "+username+" no Existe!");
    }
    
}
