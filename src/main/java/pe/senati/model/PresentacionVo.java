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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "presentaciones")
public class PresentacionVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_presentacion;
    
    @Column
    private String presentacion;
    
    @JsonIgnore
    @OneToMany(mappedBy = "presentacion")
    private Collection<ProductoVo> itemspresentacion = new ArrayList<>();

    public PresentacionVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id_presentacion);
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
        final PresentacionVo other = (PresentacionVo) obj;
        if (!Objects.equals(this.id_presentacion, other.id_presentacion)) {
            return false;
        }
        return true;
    }

    public Integer getId_presentacion() {
        return id_presentacion;
    }

    public void setId_presentacion(Integer id_presentacion) {
        this.id_presentacion = id_presentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public Collection<ProductoVo> getItemspresentacion() {
        return itemspresentacion;
    }

    public void setItemspresentacion(Collection<ProductoVo> itemspresentacion) {
        this.itemspresentacion = itemspresentacion;
    }
    
    
    
}
