public class Producto {

    String nombre;
    String origen;
    Double peso;
    Double precio;


    public Producto(String nombre, String origen, Double peso, Double precio) {
        this.nombre = nombre;
        this.origen = origen;
        this.peso = peso;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return this.origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Double getPeso() {
        return this.peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", origen='" + getOrigen() + "'" +
            ", peso='" + getPeso() + "'" +
            ", precio='" + getPrecio() + "'" +
            "}";
    }
    
}
