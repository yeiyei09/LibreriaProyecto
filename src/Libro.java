
public class Libro {
    String titulo, nombreA, apellidoA, editorial, isbn, fecha;
    int precio, vendidos;

    public Libro(String titulo, String nombreA, String apellidoA, String editorial, String isbn, String fecha, int precio, int vendidos){
        this.titulo = titulo;
        this.nombreA = nombreA;
        this.apellidoA = apellidoA;
        this.editorial = editorial;
        this.isbn = isbn;
        this.fecha = fecha;
        this.precio = precio;
        this.vendidos = vendidos;
    }

    public void librosVendidos(int decision, Libro[] libro){
        for(int i = 0; i < libro.length; i++){
            System.out.println("Libro: " + libro[i].titulo);
            System.out.println("Cantidad vendidos hoy: " + libro[i].vendidos);
        }
    }
    
}
