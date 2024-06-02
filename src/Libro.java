
public class Libro {
    String titulo, nombreA, apellidoA, editorial, ISBN, fechaC;
    int precio, vendidosDia, ejemplares;

    public Libro(String titulo, String nombreA, String apellidoA, String editorial, String ISBN, String fechaC, int precio, int vendidosDia, int ejemplares){
        this.titulo = titulo;
        this.nombreA = nombreA;
        this.apellidoA = apellidoA;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.fechaC = fechaC;
        this.precio = precio;
        this.vendidosDia = vendidosDia;
        this.ejemplares = ejemplares;
    }
    //Metodo para ordenar alfabeticamente
    
    //MetodoS para la RN 1


    //Metodo para la RN 4
    public void librosVendidos(int decision, Libro[] libro){
        for(int i = 0; i < libro.length; i++){
            System.out.println("Libro: " + libro[i].titulo);
            System.out.println("Cantidad vendidos hoy: " + libro[i].vendidosDia);
        }
    }


    
}
