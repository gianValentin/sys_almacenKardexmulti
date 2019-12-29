/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DetalleVo_ID implements Serializable {
    
    @ManyToOne
    private VentaVo ventaVo;
    
    @ManyToOne
    private ProductoVo productoVo;

    public DetalleVo_ID() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.ventaVo);
        hash = 47 * hash + Objects.hashCode(this.productoVo);
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
        final DetalleVo_ID other = (DetalleVo_ID) obj;
        if (!Objects.equals(this.ventaVo, other.ventaVo)) {
            return false;
        }
        if (!Objects.equals(this.productoVo, other.productoVo)) {
            return false;
        }
        return true;
    }
    
    public VentaVo getVentaVo() {
        return ventaVo;
    }

    public void setVentaVo(VentaVo ventaVo) {
        this.ventaVo = ventaVo;
    }

    public ProductoVo getProductoVo() {
        return productoVo;
    }

    public void setProductoVo(ProductoVo productoVo) {
        this.productoVo = productoVo;
    }
    
    
    
}
