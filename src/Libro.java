
public class Libro {
    String titulo, nombreA, apellidoA, editorial, ISBN, fechaC;
    int precio, vendidosDia, ejemplares, estado;

    public Libro(String titulo, String nombreA, String apellidoA, String editorial, String ISBN, String fechaC, int precio, int vendidosDia, int ejemplares, int estado){
        this.titulo = titulo;
        this.nombreA = nombreA;
        this.apellidoA = apellidoA;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.fechaC = fechaC;
        this.precio = precio;
        this.vendidosDia = vendidosDia;
        this.ejemplares = ejemplares;
        this.estado = estado;  
    }
}
