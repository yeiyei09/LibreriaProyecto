public class Libreria {
    public static int librosR = 0; //librosR es el numero de libros nuevos que se han registrado
    static Libro[] lib = new Libro[2];
    public static void main(String[] args) throws Exception {
        System.out.println("AQUI VA EL PROYECTO");
        Inventario inv = new Inventario();
        inv.agg(lib);
        System.out.println(librosR);
        for (int i =0; i < 2; i++){
            System.out.println("cantidades"+ lib[i].titulo);
        }
    }
}
