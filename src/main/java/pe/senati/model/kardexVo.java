
package pe.senati.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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
@Table(name = "kardex")
public class kardexVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_kardex;
    
    @Column
    private Integer stock_actual;
    
    @Column
    private Integer stock_anterior;
    
    @Column
    private Double precio_compra;
    
    @Column
    private Double precio_venta;
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.kardexVo")
    private Set<Detalle_EntradaVo> itemsDetalle = new HashSet<>();
    
    @ManyToOne
    @JoinColumn(
            name = "id_producto",
            nullable = false,
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references productos(id_producto)")
    )
    private ProductoVo producto;   

    public kardexVo() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id_kardex);
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
        final kardexVo other = (kardexVo) obj;
        if (!Objects.equals(this.id_kardex, other.id_kardex)) {
            return false;
        }
        return true;
    }

    public Integer getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(Integer id_kardex) {
        this.id_kardex = id_kardex;
    }

    public Integer getStock_actual() {
        return stock_actual;
    }

    public void setStock_actual(Integer stock_actual) {
        this.stock_actual = stock_actual;
    }

    public Integer getStock_anterior() {
        return stock_anterior;
    }

    public void setStock_anterior(Integer stock_anterior) {
        this.stock_anterior = stock_anterior;
    }

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public ProductoVo getProducto() {
        return producto;
    }

    public void setProducto(ProductoVo producto) {
        this.producto = producto;
    }

    public Set<Detalle_EntradaVo> getItemsDetalle() {
        return itemsDetalle;
    }

    public void setItemsDetalle(Set<Detalle_EntradaVo> itemsDetalle) {
        this.itemsDetalle = itemsDetalle;
    }
    

    @Override
    public String toString() {
        return "kardexVo{" + "id_kardex=" + id_kardex + ", stock_actual=" + stock_actual + ", stock_anterior=" + stock_anterior + ", precio_compra=" + precio_compra + ", precio_venta=" + precio_venta + ", producto=" + producto + '}';
    }

    
    
    
}
