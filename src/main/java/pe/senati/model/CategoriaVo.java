/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class CategoriaVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_categoria;
    
    @Column
    private String codigo;
    
    @Column
    private String categoria;    
    
    @Column
    private String status = "Active";
    
    @JsonIgnore
    @OneToMany(mappedBy = "categoria")
    private Collection<ProductoVo> itemsProducto = new ArrayList<>();
    
    @ManyToOne
    @JoinColumn(
            name = "id_user",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_user) references users (id_user)")
    )
    private UserVo user;

    public CategoriaVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id_categoria);
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
        final CategoriaVo other = (CategoriaVo) obj;
        if (!Objects.equals(this.id_categoria, other.id_categoria)) {
            return false;
        }
        return true;
    }

    public Integer getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria.toUpperCase();
    }

    public Collection<ProductoVo> getItemsProducto() {
        return itemsProducto;
    }

    public void setItemsProducto(Collection<ProductoVo> itemsProducto) {
        this.itemsProducto = itemsProducto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo.toUpperCase();
    }        

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CategoriaVo{" + "id_categoria=" + id_categoria + ", codigo=" + codigo + ", categoria=" + categoria + ", status=" + status + ", itemsProducto=" + itemsProducto + ", user=" + user + '}';
    }

 
    
   
}
