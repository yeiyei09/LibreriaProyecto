package com.Libro2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String titulo;
        String apellido;
        String nombre;
        float precio;
        String editorial;
        String isbn;
        String fechaCopyright;
        int numEjemplares;
        byte estado;

        System.out.print("Digite la cantidad de libros que puede almacenar la biblioteca: ");
        int tamañoBiblio = sc.nextInt(); // Define el tamaño del vector

            System.out.print("\nDigite la cantidad de libros recibidos: ");

            int cantidadDeLibros = sc.nextInt(); // Aqui se colocan la cantidad de libros que se reciben


            Libro libros[] = new Libro[tamañoBiblio];

            for (int i = 0; i < cantidadDeLibros; i++) {    //Se llena el vector con cada atributo de cada libro
                System.out.println("\nLibro " + (i + 1));

                System.out.print("Digite el Titulo del Libro: ");
                titulo = sc.next();

                System.out.print("Digite el apellido del autor: ");
                apellido = sc.next();

                System.out.print("Digite el nombre del autor: ");
                nombre = sc.next();

                System.out.print("Digite el precio del Libro: ");
                precio = sc.nextFloat();

                System.out.print("Digite la editorial: ");
                editorial = sc.next();

                System.out.print("Digite el código ISBN: ");
                isbn = sc.next();

                System.out.print("Digite la fecha del CopyRight: ");
                fechaCopyright = sc.next();

                System.out.print("Digite el número de ejemplares: ");
                numEjemplares = sc.nextInt();

                do {
                    System.out.print("Digite el estado (1:Libro disponible - 0:Libro agotado): ");
                    estado = sc.nextByte();
                } while (estado > 1 || estado < 0); // Validar que el número ingresado entre entre 1 y 0

                libros2[i] = new com.libro2.Libro2(titulo.toUpperCase(), apellido.toUpperCase(), nombre.toUpperCase(), precio,
                        editorial, isbn.toUpperCase(),
                        fechaCopyright.toUpperCase(), numEjemplares, estado);
            }

            int buscar;
            String buscarLibro = "";
            String buscarAutor = "";

            boolean bandera = false;
            int respuesta = 0;
            
            do {
                do {
                    System.out.print("\n1: Para buscar por Nombre del libro 2: Para buscar por nombre del autor: ");
                    buscar = sc.nextInt();
                } while (buscar > 2 && buscar < 1); // Validar que el número ingresado entre entre 1 y 2
                if (buscar == 1) {
                    System.out.print("\nDigite el nombre del libro a buscar: ");
                    buscarLibro = sc.next().toUpperCase();
                } else {
                    System.out.print("\nDigite el nombre del autor a buscar: ");
                    buscarAutor = sc.next().toUpperCase();
                }

                for (int i = 0; i < libros.length; i++) {
                    if (libros[i] != null) {
                        if (buscarLibro.equals(String.valueOf(libros[i].getTitulo()))
                                || buscarAutor.equals(String.valueOf(libros[i].getNombre()))) {
                            System.out.println("El libro fue encontrado");
                            System.out.println("Libro: " + libros[i].toString());
                            bandera = true;
                            break;
                        }
                    }
                }

                if (bandera == false) {
                    do {
                        System.out.println("El libro no fue encontrado");
                        System.out.print("¿Quiere volver a buscar? 1:sí / 2:no: ");
                        respuesta = sc.nextInt();
                    } while (respuesta > 2 && respuesta < 2);
                } else {
                    break;
                }
            } while (respuesta == 1);
        }
}