package pe.senati.model;

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
@Table(name = "detalle_entrada")
@AssociationOverrides({
    @AssociationOverride(name = "id.kardexVo",
            joinColumns = @JoinColumn(name = "id_kardex"),
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_kardex) references kardex(id_kardex)")),
    @AssociationOverride(name = "id.entradaVo",
            joinColumns = @JoinColumn(name = "id_entrada"),
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_entrada) references entradas(id_entrada)"))
})
public class Detalle_EntradaVo {
    
    @EmbeddedId
    private Detalle_Entrada_ID id =new Detalle_Entrada_ID();
    
    @Column
    private Integer cantidad;
    
    @Column
    private Double precio;
    
    public Detalle_EntradaVo() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Detalle_EntradaVo other = (Detalle_EntradaVo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public Detalle_Entrada_ID getId() {
        return id;
    }

    public void setId(Detalle_Entrada_ID id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
}
