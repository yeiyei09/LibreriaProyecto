import java.util.Scanner;
public class Inventario {

    Scanner sc = new Scanner(System.in);
    //ordena alfabeticamente
    public void ordenarInventario(Libro[]libro){
        int mn;
        String menor;
        Libro aux;
        
        for (int i = 0; i < libro.length; i++) {
            menor = libro[i].titulo;
            mn = i;
            for (int j = i + 1; j < libro.length; j++) {
                if(menor.compareTo(libro[j].titulo)>0){
                    mn = j;
                    
                }
                aux = libro[i];
                libro[i] = libro[mn];
                libro[mn] = aux;
            }
        }
    }

    //agregar libros
    public void agg(Libro[]libro, int opcion){
        boolean nuevoLibro = false, salir;
        String tit, nomA, apllA, editorial, isbn, fechaC;
        int precio, vendidosDia, ejemplar;
        while(true){
            System.out.println("Ingrese los datos del libro");
            System.out.println("Ingrese el titulo del libro");
            tit = sc.next();
            System.out.println("Ingrese el nombre del autor de : "+tit);
            nomA = sc.next();
            System.out.println("Ingrese el apellido del autor de: "+tit);
            apllA = sc.next();
            System.out.println("Ingrese la editorial del libro "+tit);
            editorial = sc.next();
            System.out.println("Ingrese el ISBN del libro "+tit);
            isbn = sc.next();
            System.out.println("Ingrese la fecha en dd/mm/aa "+tit);
            fechaC = sc.next();
            System.out.println("Ingrese el precio de: "+tit);
            precio  = sc.nextInt();
            vendidosDia = 0;
            System.out.println("Ingrese el numero de ejemplares que tiene: "+tit);
            ejemplar = sc.nextInt();

            for(int i = 0; i<=Libreria.librosR; i++){
                if(libro[i].ISBN.equals(isbn)){
                    libro[i].ejemplares += ejemplar;
                }
            }
        }


    }

}
/*
 * 
         nombreA;
         apellidoA;
        this.editorial = editorial;
       isbn;
         fechaC;
        precio;
        vendidosDia;
 */
