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
                if(libro[i].ISBN.equals(isbn) && libro[i].titulo.equals(tit)){
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
                    System.out.println("NO HAY MAS ESPACIOS PARA LIBROS, VERIFIQUE EL ISBN Y TITULO SI QUIERE AGREGAR CANTIDADES EXISTENTES");
                }
            }
            while(true){
                System.out.println("¿Desea agregar otro libro? (si/no)");
                opcion = sc.next();
                sc.nextLine();
                if(opcion.equalsIgnoreCase("si") || opcion.equalsIgnoreCase("no")){
                    if(opcion.equalsIgnoreCase("si")){
                        salir = true;
                        break;
                    }else{
                        if(opcion.equalsIgnoreCase("no")){
                            salir = false;
                            break;
                        }
                    }
                     
                }else{
                    System.out.println("Opcion no valida, digite si o no");
                }
                 
            }
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
    public void venderLibros(Libro[] libro) {
        String comprar, decision;
        int unidades, i;
        boolean comprobar = true, encontrado;
    
        while (comprobar) {
            encontrado = false;
            System.out.println("Ingrese el titulo del libro que desea vender: ");
            comprar = sc.nextLine();
            for (i = 0; i < Libreria.librosR; i++) {
                if (comprar.equalsIgnoreCase(libro[i].titulo)) {
                    encontrado = true;
                    break;
                }
            }
            while (true) {
                if (!encontrado) {
                    System.out.println("Libro no encontrado,¿Quiere intentar de nuevo? (si/no)");
                    decision = sc.nextLine();
                    if (decision.equalsIgnoreCase("no") || decision.equalsIgnoreCase("si")) {
                        if (decision.equalsIgnoreCase("si")) {
                            encontrado = false;
                            break;
                        } else {
                            if (decision.equalsIgnoreCase("no")) {
                                comprobar = false;
                                break;
                            } else {
                                System.out.println("Entrada no valida, elija si o no");
                            }
                        }
                    }
                } else {
                    break; 
                }
            }
    
            while (encontrado) {
                System.out.println("Ingrese la cantidad de unidades del libro que desea vender");
    
                try {
                    unidades = sc.nextInt();
                    sc.nextLine(); 
                } catch (Exception e) {
                    System.out.println("Ingrese un dato valido");
                    sc.next(); 
                    continue;
                }
    
                if (unidades > libro[i].ejemplares && libro[i].estado == 2) {
                    System.out.println("La cantidad que se quiere vender excede las unidades disponibles");
                    System.out.println("Se quiere vender " + unidades);
                    System.out.println("Hay disponibles " + libro[i].ejemplares);
                    System.out.println("Intentelo de nuevo");
                } else {
                    if (unidades > libro[i].ejemplares && libro[i].estado == 1) {
                        int aux = libro[i].ejemplares;
                        libro[i].ejemplares -= unidades;
                        libro[i].vendidosDia += unidades;
                        if (libro[i].ejemplares < 0) {
                            System.out.println("Esta venta excede las unidades disponibles en inventario, pero es reimprimible, por lo que se deben de pedir " + (-1 * libro[i].ejemplares) + " unidades a la editorial " + libro[i].editorial);
                            System.out.println("Se pudieron vender al instante " + aux + " unidades");
                        }
                    } else {
                        if (unidades <= libro[i].ejemplares) {
                            libro[i].ejemplares -= unidades;
                            libro[i].vendidosDia += unidades;
                            System.out.println("Se vendieron " + unidades + " del libro " + libro[i].titulo);
                        }
                    }
                }
                System.out.println("¿Desea vender otro libro?");
                decision = sc.nextLine();
                if (decision.equalsIgnoreCase("si")) {
                    break;
                } else {
                    comprobar = false;
                    break;
                }
            }
        }
    }

    //buscar libro
    public void buscarLibro(Libro[]libro){
        boolean buscarNuevo = true, encontrado;
        int i;
        String nombre, decision;

        while (buscarNuevo) {
            System.out.println("Si desea buscar por título del libro ingrese 1 o si es por nombre del autor ingrese 2");
            int opcion = sc.nextInt();
            sc.nextLine(); 

            switch(opcion){
                case 1:
                    System.out.println("Ingrese el título del libro a buscar:");
                    nombre = sc.nextLine();
                    encontrado = false;
                    for (i = 0; i<Libreria.librosR; i++) {
                        if (libro[i].titulo.equalsIgnoreCase(nombre)) {
                            System.out.println("Libro encontrado:");
                            System.out.println("titulo: "+libro[i].titulo+" | Autor: "+libro[i].nombreA +" "+libro[i].apellidoA+ " | Editorial: "+ libro[i].editorial+ " | ISBN: "+libro[i].ISBN+ " | Fecha Copyright: "+libro[i].fechaC);
                            encontrado = true;
                            break;
                        }else{
                            System.out.println("No se encontró libro.");
                        } 
                    }
                    if(encontrado){
                        if(libro[i].estado==1 && libro[i].ejemplares<0){
                            System.out.println("Libro disponible pero se debe de mandar a reimprimir con la editorial "+libro[i].editorial);
                        }else{
                            if(libro[i].ejemplares>0){
                                System.out.println("Libro disponible");
                            }
                        }
                    }
                    break;
                case 2: 
                System.out.println("Ingrese el autor del libro a buscar:");
                    nombre = sc.nextLine();
                    encontrado = false;
                    for (i = 0; i<Libreria.librosR; i++) {
                        if (libro[i].nombreA.equalsIgnoreCase(nombre)) {
                            System.out.println("Libro encontrado:");
                            System.out.println("titulo: "+libro[i].titulo+" | Autor: "+libro[i].nombreA +" "+libro[i].apellidoA+ " | Editorial: "+ libro[i].editorial+ " | ISBN: "+libro[i].ISBN+ " | Fecha Copyright: "+libro[i].fechaC);
                            encontrado = true;
                            break;
                        }else{
                            System.out.println("No se encontró este autor.");
                        }  
                    }
                    if(encontrado){
                        if(libro[i].estado==1 && libro[i].ejemplares<0){
                            System.out.println("Libro disponible pero se debe de mandar a reimprimir con la editorial "+libro[i].editorial);
                        }else{
                            if(libro[i].ejemplares>0){
                                System.out.println("Libro disponible");
                            }
                        }
                    }
                    break;    
            }
            while(true){
                System.out.println("¿Desea buscar de nuevo? (si/no)");
                decision = sc.next();
                if(decision.equalsIgnoreCase("no") || decision.equalsIgnoreCase("si")){
                    if(decision.equalsIgnoreCase("no")){
                        buscarNuevo = false;
                        break;
                    }else{
                        if(decision.equalsIgnoreCase("si"))
                            break;
                    }
                }else{
                    System.out.println("opcion no valida");
                }
            }
            
        }
    }

    //Mostrar libros vendidos
    public void listaVendidos(Libro[]libros){
        System.out.println("La lista de libros vendidos es");
        for (int i = 0; i < Libreria.librosR; i++) {
            if(libros[i].vendidosDia>0){
                System.out.println("libro: "+libros[i].titulo+ " | Ventas del dia: "+libros[i].vendidosDia);
            }
        }
        
    }
}


