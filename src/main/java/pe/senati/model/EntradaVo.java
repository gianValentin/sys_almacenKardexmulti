
package pe.senati.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "entradas")
public class EntradaVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entradaM;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date fecha_entrada = new Date();
    
    @Column
    private String factura;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date fecha_factura;   
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.entradaVo")
    private Set<Detalle_EntradaVo> itemsDetalle = new HashSet<>();

    public EntradaVo() {
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id_entradaM);
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
        final EntradaVo other = (EntradaVo) obj;
        if (!Objects.equals(this.id_entradaM, other.id_entradaM)) {
            return false;
        }
        return true;
    }

    public Integer getId_entradaM() {
        return id_entradaM;
    }

    public void setId_entradaM(Integer id_entradaM) {
        this.id_entradaM = id_entradaM;
    }

    public Date getFecha_entrada() {
        return fecha_entrada;
    }

    public void setFecha_entrada(Date fecha_entrada) {
        this.fecha_entrada = fecha_entrada;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public Date getFecha_factura() {
        return fecha_factura;
    }

    public void setFecha_factura(Date fecha_factura) {
        this.fecha_factura = fecha_factura;
    }

    public Set<Detalle_EntradaVo> getItemsDetalle() {
        return itemsDetalle;
    }

    public void setItemsDetalle(Set<Detalle_EntradaVo> itemsDetalle) {
        this.itemsDetalle = itemsDetalle;
    }
    
    @Override
    public String toString() {
        return "EntradaVo{" + "id_entradaM=" + id_entradaM + ", fecha_entrada=" + fecha_entrada + ", factura=" + factura + ", fecha_factura=" + fecha_factura + '}';
    }
    
    
    
}
