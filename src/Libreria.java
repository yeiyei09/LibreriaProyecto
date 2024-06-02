import java.util.Scanner;
public class Libreria {
    public static int librosR = 0; //librosR es el numero de libros nuevos que se han registrado
    static Libro[] lib = new Libro[1000];
    public static void main(String[] args) throws Exception {
        int op;
        boolean menu = true;
        Scanner sc = new Scanner(System.in);
        Inventario inv = new Inventario();
        
        System.out.println("<<<<BIENVENIDO A LA BIBLIOTECA LIBROS Y REVISTAS>>>>");
        while(menu){
            System.out.println("");
            System.out.println("Digite la opción que desee");
            System.err.println("1: Entrega de cargamentos de libros");
            System.out.println("2: Buscar libro y su información");
            System.out.println("3: Comprar libros");
            System.out.println("4: Mostrar los libros vendidos en inventario");
            System.out.println("5: Ver un listado de todos los libros en inventario");
            System.out.println("6: Finalizar programa");
            while(true){
                try {
                    op = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Ingrese un dato valido");
                }
            }
            switch(op){
                case 1:
                    inv.agg(lib);
                    inv.ordenarInventario(lib);
                    inv.eliminarLibros(lib);
                    System.out.println("El inventario ha sido agregado y organizado");
                    break;
                
                case 2: 
                    inv.buscarLibro(lib);
                    break;

                case 3:
                    inv.venderLibros(lib);
                    inv.eliminarLibros(lib);
                    System.out.println("Inventario actualizado");
                    break;
                
                case 4: 
                    inv.listaVendidos(lib);
                    break;
                
                case 5:
                    inv.mostrarLibros(lib);
                    break;

                case 6:
                    menu = false;
                    System.out.println("PROGRAMA FINALIZADO");
                    break;
            }
        }
    }
}
