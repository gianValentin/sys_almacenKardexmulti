/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "detalles")
@AssociationOverrides({
    @AssociationOverride(name = "id.ventaVo",
        joinColumns =  @JoinColumn(name = "id_venta"),
        foreignKey = @ForeignKey(foreignKeyDefinition="foreign key (id_venta) references ventas(id_venta)")),        
    @AssociationOverride(name = "id.productoVo",
        joinColumns =  @JoinColumn(name = "id_producto"),
        foreignKey = @ForeignKey(foreignKeyDefinition="foreign key (id_producto) references productos(id_producto)"))
})
public class DetalleVo implements Serializable {
    
    @EmbeddedId
    private DetalleVo_ID id=new DetalleVo_ID();
    
    @Column
    private Float precio;
    
    @Column
    private Integer cantidad;

    public DetalleVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.id);
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
        final DetalleVo other = (DetalleVo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public DetalleVo_ID getId() {
        return id;
    }

    public void setId(DetalleVo_ID id) {
        this.id = id;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}
