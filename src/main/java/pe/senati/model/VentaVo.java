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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ventas")
public class VentaVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_venta;
    
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd",iso = DateTimeFormat.ISO.DATE)
    private Date fecha_emision;
    
    @Column
    private Float precio_total;
    
    @Column
    private Integer cantidad_total;
    
    @ManyToOne
    @JoinColumn(
            name = "id_user",
            nullable = false,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_user) references users (id_user)")
    )
    private UserVo user=new UserVo();
    
    
    @ManyToOne
    @JoinColumn(
            name = "id_cliente",
            nullable = true,            
            foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_cliente) references clientes (id_cliente)")
    )
    private ClienteVo cliente=new ClienteVo();
    
    @JsonIgnore
    @OneToMany(mappedBy = "id.ventaVo")
    private Set<DetalleVo> itemsDetalle = new HashSet<>();

    public VentaVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id_venta);
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
        final VentaVo other = (VentaVo) obj;
        if (!Objects.equals(this.id_venta, other.id_venta)) {
            return false;
        }
        return true;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Float getPrecio_total() {
        return precio_total;
    }

    public void setPrecio_total(Float precio_total) {
        this.precio_total = precio_total;
    }

    public Integer getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(Integer cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    public ClienteVo getCliente() {
        return cliente;
    }

    public void setCliente(ClienteVo cliente) {
        this.cliente = cliente;
    }

    public Set<DetalleVo> getItemsDetalle() {
        return itemsDetalle;
    }

    public void setItemsDetalle(Set<DetalleVo> itemsDetalle) {
        this.itemsDetalle = itemsDetalle;
    }

    
}
