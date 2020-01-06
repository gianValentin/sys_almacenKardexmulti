
package pe.senati.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidades")
public class UnidadVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_unidad;
    
    @Column
    private String unidad;
    
    @Column
    private String status = "Active";

    @JsonIgnore
    @OneToMany(mappedBy = "unidad")
    private Collection<ProductoVo> itemsUnidad = new ArrayList<>();
    
    public UnidadVo() {
    }

    public Integer getId_unidad() {
        return id_unidad;
    }

    public void setId_unidad(Integer id_unidad) {
        this.id_unidad = id_unidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<ProductoVo> getItemsUnidad() {
        return itemsUnidad;
    }

    public void setItemsUnidad(Collection<ProductoVo> itemsUnidad) {
        this.itemsUnidad = itemsUnidad;
    }    
    
    
}
