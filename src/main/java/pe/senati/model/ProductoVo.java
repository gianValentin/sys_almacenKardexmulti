/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.senati.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
    private String nombre_comercial;
    
    @Column
    private String nombre_generico;
    
    @Column
    private String concentracion;
    
    @Column
    private Integer stock;
    
    @Column
    private Double precio;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date fecha_caducidad;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date fecha_registro;
    
    @ManyToOne
    @JoinColumn(
            name = "id_presentacion",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_presentacion) references presentaciones (id_presentacion)")
    )
    private PresentacionVo presentacion;
    
    @ManyToOne
    @JoinColumn(
            name = "id_categoria",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_categoria) references categorias (id_categoria)")
    )
    private CategoriaVo categoria;
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.productoVo")
    private Set<DetalleVo> itemsDetalle=new HashSet<>();

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

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getNombre_generico() {
        return nombre_generico;
    }

    public void setNombre_generico(String nombre_generico) {
        this.nombre_generico = nombre_generico;
    }

    public String getConcentracion() {
        return concentracion;
    }

    public void setConcentracion(String concentracion) {
        this.concentracion = concentracion;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    public Date getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public Set<DetalleVo> getItemsDetalle() {
        return itemsDetalle;
    }

    public void setItemsDetalle(Set<DetalleVo> itemsDetalle) {
        this.itemsDetalle = itemsDetalle;
    }        
        public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public PresentacionVo getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(PresentacionVo presentacion) {
        this.presentacion = presentacion;
    }

    public CategoriaVo getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaVo categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
        
}
