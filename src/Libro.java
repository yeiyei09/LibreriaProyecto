
public class Libro {
    String titulo, nombreA, apellidoA, editorial, isbn, fechaC;
    int precio, vendidosDia;

    public Libro(String titulo, String nombreA, String apellidoA, String editorial, String isbn, String fechaC, int precio, int vendidosDia){
        this.titulo = titulo;
        this.nombreA = nombreA;
        this.apellidoA = apellidoA;
        this.editorial = editorial;
        this.isbn = isbn;
        this.fechaC = fechaC;
        this.precio = precio;
        this.vendidosDia = vendidosDia;
    }
    //Metodo para ordenar alfabeticamente
    public void ordenarSeleccion(Libro[]libro){
        int mn;
        String menor;
        Libro aux;
        String[] nombres = new String[libro.length];
        
        for (int i = 0; i < nombres.length; i++) {
            menor = libro[i].titulo;
            mn = i;
            for (int j = i + 1; j < nombres.length; j++) {
                if(menor.compareTo(libro[j].titulo)>0){
                    mn = j;
                    
                }
                aux = libro[i];
                libro[i] = libro[mn];
                libro[mn] = aux;
            }
        }
    }

    //MetodoS para la RN 1


    //Metodo para la RN 4
    public void librosVendidos(int decision, Libro[] libro){
        for(int i = 0; i < libro.length; i++){
            System.out.println("Libro: " + libro[i].titulo);
            System.out.println("Cantidad vendidos hoy: " + libro[i].vendidosDia);
        }
    }


    
}
