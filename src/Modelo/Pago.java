
package Modelo;


public class Pago {
    
    private int id;
    private String socio;
    private String vendedor;
    private double total;

    public Pago() {
    }

    public Pago(int id, String socio, String vendedor, double total) {
        this.id = id;
        this.socio = socio;
        this.vendedor = vendedor;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSocio() {
        return socio;
    }

    public void setSocio(String socio) {
        this.socio = socio;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    
}
