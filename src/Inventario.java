public class Inventario {

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
    public void agg(Libro[]libro){
        

    }

}
