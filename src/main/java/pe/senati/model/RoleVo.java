/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RoleVo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_role;
    
    private String type=RoleType.ADMIN.name();
    
    @ManyToMany(mappedBy = "itemsRole",fetch = FetchType.EAGER)
    private Set<UserVo> itemsUser =new HashSet<>();

    public RoleVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id_role);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RoleVo other = (RoleVo) obj;
        if (!Objects.equals(this.id_role, other.id_role)) {
            return false;
        }
        return true;
    }
    
    

    public Integer getId_role() {
        return id_role;
    }

    public void setId_role(Integer id_role) {
        this.id_role = id_role;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Set<UserVo> getItemsUser() {
        return itemsUser;
    }

    public void setItemsUser(Set<UserVo> itemsUser) {
        this.itemsUser = itemsUser;
    }    
    
}
