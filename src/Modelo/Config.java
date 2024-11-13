
package Modelo;

public class Config {
    
    private int id;
    private String nombre;
    private String cuil;
    private String telefono;
    private String direccion;

    public Config() {
    }

    public Config(int id, String nombre, String cuil, String telefono, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.cuil = cuil;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCuil() {
        return cuil;
    }

    public void setCuil(String cuil) {
        this.cuil = cuil;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
    
}
