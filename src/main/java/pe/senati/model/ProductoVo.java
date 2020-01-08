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
import java.util.Date;
import java.util.List;
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
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "productos")
public class ProductoVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_producto;
    
    @Column
    private String codigo_producto;
    
    @Column
    private String nombre;
    
    @Column
    private String nombre_reducido;
    
    @Column
    private String abrev_unidad;    
    
    @Column
    private String status = "Active";
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date fecha_registro = new Date();
    
    @ManyToOne
    @JoinColumn(
            name = "id_tipo",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_tipo) references tipos (id_tipo)")
    )
    private TipoVo tipo;
    
    @ManyToOne
    @JoinColumn(
            name = "id_categoria",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_categoria) references categorias (id_categoria)")
    )
    private CategoriaVo categoria;          
            
    @ManyToOne
    @JoinColumn(
            name = "id_unidad",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_unidad) references unidades (id_unidad)")
    )
    private UnidadVo unidad;  
    
    @JsonIgnore
    @OneToMany(mappedBy = "producto")
    private Collection<kardexVo> itemsKardex = new ArrayList<>();

    public ProductoVo() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.id_producto);
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
        final ProductoVo other = (ProductoVo) obj;
        if (!Objects.equals(this.id_producto, other.id_producto)) {
            return false;
        }
        return true;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public String getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(String codigo_producto) {
        this.codigo_producto = codigo_producto.toUpperCase();
    }        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getNombre_reducido() {
        return nombre_reducido;
    }

    public void setNombre_reducido(String nombre_reducido) {
        this.nombre_reducido = nombre_reducido.toUpperCase();
    }

    public String getAbrev_unidad() {
        return abrev_unidad;
    }

    public void setAbrev_unidad(String abrev_unidad) {
        this.abrev_unidad = abrev_unidad.toUpperCase();
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public TipoVo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVo tipo) {
        this.tipo = tipo;
    }

    public CategoriaVo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVo categoria) {
        this.categoria = categoria;
    }

    public UnidadVo getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadVo unidad) {
        this.unidad = unidad;
    }      

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status.toUpperCase();
    }        

    public Collection<kardexVo> getItemsKardex() {
        return itemsKardex;
    }

    public void setItemsKardex(Collection<kardexVo> itemsKardex) {
        this.itemsKardex = itemsKardex;
    }

    @Override
    public String toString() {
        return "ProductoVo{" + "id_producto=" + id_producto + ", codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", nombre_reducido=" + nombre_reducido + ", abrev_unidad=" + abrev_unidad + ", status=" + status + ", fecha_registro=" + fecha_registro + ", tipo=" + tipo + ", categoria=" + categoria + ", unidad=" + unidad + ", itemsKardex=" + itemsKardex + '}';
    }
    
    
}
