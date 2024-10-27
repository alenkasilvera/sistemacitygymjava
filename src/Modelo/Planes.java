
package Modelo;

public class Planes {
    
    private int id;
    private String codigo;
    private String nombre;
    private String entrenador;
    private int cupos;
    private double precio;

    public Planes() {
    }

    public Planes(int id, String codigo, String nombre, String entrenador, int cupos, double precio) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.cupos = cupos;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
