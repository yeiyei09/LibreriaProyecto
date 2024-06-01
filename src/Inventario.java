import java.util.Scanner;
public class Inventario {

    Scanner sc = new Scanner(System.in);
    //ordena alfabeticamente
    public void ordenarInventario(Libro[]libro){
        int mn;
        String menor;
        Libro aux;
        
        for (int i = 0; i < Libreria.librosR; i++) {
            menor = libro[i].titulo;
            mn = i;
            for (int j = i + 1; j < Libreria.librosR; j++) {
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
    public void agg(Libro[]libro){
        boolean salir = true;
        String tit, nomA, apllA, editorial, isbn, fechaC, opcion;
        int precio = 0, vendidosDia, ejemplar = 0, estado = 0;
        while(salir){
            boolean existe = false, valido = true;
            System.out.println("Ingrese los datos del libro");
            
           //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            System.out.println("Ingrese el titulo del libro");
            tit = sc.nextLine();
            
            System.out.println("Ingrese el nombre del autor de : "+tit);
            nomA = sc.nextLine();
            
            System.out.println("Ingrese el apellido del autor de: "+tit);
            apllA = sc.nextLine();
            
            System.out.println("Ingrese la editorial del libro "+tit);
            editorial = sc.nextLine();
            
            System.out.println("Ingrese el ISBN del libro "+tit);
            isbn = sc.nextLine();
            
            System.out.println("Ingrese la fecha en dd/mm/aa "+tit);
            fechaC = sc.nextLine();
            
            while(valido){
                try {
                    System.out.println("Ingrese el precio de: "+tit);
                    precio  = sc.nextInt();
                    sc.nextLine();
                    valido = false;
                } catch (Exception e) {
                    System.out.println("Datos no válidos, ingrese de nuevo");
                    sc.next();
                }
            }
            valido = true;
            while(valido){
                try{
                    System.out.println("Ingrese el numero de ejemplares que tiene: "+tit);
                    ejemplar = sc.nextInt();
                    sc.nextLine();
                    valido = false;
                }catch(Exception e){
                    System.out.println("Datos no válidos, ingrese de nuevo");
                    sc.next();
                }
            }
            valido = true;
            while(valido){
                System.out.println("Ingrese el estado de "+tit+". 1 Si el libro se puede reimprimir, 2 si no se puede reimprimir");
                try {
                    estado = sc.nextInt();
                    if(estado == 1 || estado == 2){
                        valido = false;
                    }
                } catch (Exception e) {
                    System.out.println("Datos no válidos, ingrese de nuevo");
                    sc.next();
                }
            }

            vendidosDia = 0;

            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            for(int i = 0; i<Libreria.librosR; i++){
                if(libro[i].ISBN.equals(isbn)){
                    libro[i].ejemplares += ejemplar;
                    existe = true;
                    break;
                }
            }
            if(!existe){
                if(Libreria.librosR < Libreria.lib.length){
                    libro[Libreria.librosR] = new Libro(tit, nomA, apllA, editorial, isbn, fechaC, precio, vendidosDia, ejemplar, estado);
                    Libreria.librosR ++;
                }else{
                    System.out.println("NO HAY MAS ESPACIOS PARA LIBROS, VERIFIQUE EL ISBN SI QUIERE AGREGAR CANTIDADES EXISTENTES");
                }
            }

            System.out.println("¿Desea agregar otro libro?");
            opcion = sc.next();
            if(!opcion.equalsIgnoreCase("si"))
                salir = false;    
        }
    }

    //eliminar libros automaticamente
    public void eliminarLibros(Libro[]libro){
        for(int i = 0; i<Libreria.librosR; i++){
            if(libro[i].ejemplares==0 && libro[i].estado==2){
                System.out.println("El libro "+libro[i].titulo+" sera eliminado, no mas existencias disponibles");
                for(int j = i; j<Libreria.librosR-1; j++){
                    libro[j] = libro[j+1];
                }
                libro[Libreria.librosR-1] = null;
                Libreria.librosR -= 1;
            }
        }
    }

    //venta de libros
    public void venderLibros(Libro[]libro){
        String comprar, decision;
        int unidades, i;
        boolean comprobar = true, encontrado = false;

        while(comprobar){
            System.out.println("Ingrese el titulo del libro que desea vender: ");
            comprar = sc.next();
            for(i = 0; i<Libreria.librosR; i++){
                if(comprar.equalsIgnoreCase(libro[i].titulo)){
                    encontrado = true;
                    break;
                }
            }
            while(encontrado){
                System.out.println("Ingrese la cantidad de unidades del libro que desea vender");
                unidades = sc.nextInt();
                if(unidades>libro[i].ejemplares && libro[i].estado==2){
                    System.out.println("La cantidad que se quiere vender excede las unidades disponibles");
                    System.out.println("Se quiere vender "+unidades);
                    System.out.println("Hay disponibles "+ libro[i].ejemplares);
                    System.out.println("Intentelo de nuevo");
                }else{
                    if(unidades>libro[i].ejemplares && libro[i].estado==1){
                        int aux = libro[i].ejemplares;
                        libro[i].ejemplares -= unidades;
                        if(libro[i].ejemplares<0){
                            System.out.println("Esta venta excede las unidades disponibles en inventario, pero es reimprimible, por lo que se deben de pedir "+(-1*libro[i].ejemplares)+" unidades a la editorial "+libro[i].editorial);
                            System.out.println("Se pudieron vender al instante "+ aux+" unidades");
                        }
                    }else{
                        if(unidades<=libro[i].ejemplares){
                            libro[i].ejemplares -= unidades;
                            System.out.println("Se vendieron "+unidades+" del libro "+libro[i].titulo);
                        }
                    }                
                }
                System.out.println("¿Desea vender otro libro?");{
                    decision = sc.next();
                    if(decision.equalsIgnoreCase("si")){
                        break;
                    }else{
                        comprobar = false;
                        break;
                    }
                }
            }
        }

    }

}


