package com.libro2;

public class Libro2 {
    private String titulo;
    private String apellido;
    private String nombre;
    private float precio;
    private String editorial;
    private String isbn;
    private String fechaCopyright;
    private int numEjemplares;
    private byte estado;
    
    public Libro(String titulo, String apellido, String nombre, float precio, String editorial, String isbn,
            String fechaCopyright, int numEjemplares, byte estado) {
        this.titulo = titulo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.precio = precio;
        this.editorial = editorial;
        this.isbn = isbn;
        this.fechaCopyright = fechaCopyright;
        this.numEjemplares = numEjemplares;
        this.estado = estado;
    }
    
    @Override
    public String toString() {
        return "{"+"\nTítulo del libro: "+titulo +"\nApellido del autor: "+ apellido + "\nNombre del autor: " + nombre + "\nPrecio del libro: " + precio + "\nEditorial del libro: " + editorial + "\nCódigo ISBN: " +isbn+"\nFecha de CopyRight: "+fechaCopyright+"\nCantidad de ejemplares: "+numEjemplares+"\nEstado: "+estado+"\n}";
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getFechaCopyright() {
        return fechaCopyright;
    }

    public void setFechaCopyright(String fechaCopyright) {
        this.fechaCopyright = fechaCopyright;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(int numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public byte getEstado() {
        return estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }   
}