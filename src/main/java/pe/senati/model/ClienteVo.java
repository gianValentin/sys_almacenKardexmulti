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
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")
public class ClienteVo implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;
    
    @Column
    private String nombres;
    
    @Column
    private String apellidos;
    
    @Column
    private String Estado=EstadoCliente.ACTIVE.name();
    
    @Column
    private String sexo;
    
    @Column
    private String direccion;
    
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd",iso=DateTimeFormat.ISO.DATE)
    private Date Fecha_nac;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private Collection<VentaVo> itemsVenta=new ArrayList<>();

    public ClienteVo() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id_cliente);
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
        final ClienteVo other = (ClienteVo) obj;
        if (!Objects.equals(this.id_cliente, other.id_cliente)) {
            return false;
        }
        return true;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFecha_nac() {
        return Fecha_nac;
    }

    public void setFecha_nac(Date Fecha_nac) {
        this.Fecha_nac = Fecha_nac;
    }

    public Collection<VentaVo> getItemsVenta() {
        return itemsVenta;
    }

    public void setItemsVenta(Collection<VentaVo> itemsVenta) {
        this.itemsVenta = itemsVenta;
    }
    
    
}
