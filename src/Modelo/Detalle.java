
package Modelo;


public class Detalle {
    
    int id;
    String codigo_plan;
    int cantidad;
    double precio;
    int id_venta;

    public Detalle() {
    }

    public Detalle(int id, String codigo_plan, int cantidad, double precio, int id_venta) {
        this.id = id;
        this.codigo_plan = codigo_plan;
        this.cantidad = cantidad;
        this.precio = precio;
        this.id_venta = id_venta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo_plan() {
        return codigo_plan;
    }

    public void setCodigo_plan(String codigo_plan) {
        this.codigo_plan = codigo_plan;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    
    
}
