/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.View;

@Entity
@Table(name = "users")
public class UserVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
        
    @Column
    private String username;
    
    @Column
    private String password;
    
    @Column
    private String nombre;
    
    @Column
    private String apellido;
    
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=DateTimeFormat.ISO.DATE)
    private Date fecha_nac;
    
    @Column
    private String estado=EstadoUser.ACTIVE.name();
    
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="users_roles",
            joinColumns = @JoinColumn(name = "id_user",foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_user) references users(id_user)")),
            inverseJoinColumns = @JoinColumn(name = "id_role",foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_role) references roles(id_role)"))
    )
    private Set<RoleVo> itemsRole =new HashSet<RoleVo>();
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Collection<VentaVo> itemsVenta=new ArrayList<>();
    

    public UserVo() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.id_user);
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
        final UserVo other = (UserVo) obj;
        if (!Objects.equals(this.id_user, other.id_user)) {
            return false;
        }
        return true;
    }
    
    

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Set<RoleVo> getItemsRole() {
        return itemsRole;
    }

    public void setItemsRole(Set<RoleVo> itemsRole) {
        this.itemsRole = itemsRole;
    }        

    public Collection<VentaVo> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(Collection<VentaVo> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }
    
}
