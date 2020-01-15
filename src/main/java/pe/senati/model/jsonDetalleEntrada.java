
package pe.senati.model;


public class jsonDetalleEntrada {
    private Integer id_producto;
    private String codigo_producto;
    private String nombre;
    private Integer cantidad;    
    private Double precio;
    private Double valor_venta;

    public jsonDetalleEntrada() {
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
        this.codigo_producto = codigo_producto;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValor_venta() {
        return valor_venta;
    }

    public void setValor_venta(Double valor_venta) {
        this.valor_venta = valor_venta;
    }

    @Override
    public String toString() {
        return "jsonDetalleEntrada{" + "id_producto=" + id_producto + ", codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", cantidad=" + cantidad + ", precio=" + precio + ", valor_venta=" + valor_venta + '}';
    }
   
    
    
}
