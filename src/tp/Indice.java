package tp;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Indice {
    ArrayList<Genero> indice;

    public Indice() {
        this.indice = new ArrayList<Genero>();
    }

    private void crearGenero(String nombre, Libro libro) {
        Genero tmp = new Genero(nombre);
        tmp.addLibro(libro);
        this.indice.add(tmp);
    }

    // tomo la cantidad de generos que tiene el libro
    // recorro los generos
    // si el indice tiene el genero agrego el libro si no creo el genero y agrego el
    // libro
    public void agregarLibro(Libro libro) {
        int size = libro.getSize(); // tomo la cantidad de generos que tiene el libro
        for (int i = 0; i < size; i++) { // recorro los generos
            if(!indice.isEmpty()){
                int j = 0;
                //mientras indice no termine y no encuentre ningun libro igual sigue;
                while (j < indice.size() && !indice.get(j).esIgual(libro.getGenero(i))) {
                    j++;
                }
                if (j == indice.size()) {
                    crearGenero(libro.getGenero(i), libro);
                } else {
                    indice.get(j).addLibro(libro);
                }
            }else{
                crearGenero(libro.getGenero(0), libro);
            }
        }
    }

    public Iterator<Libro> ObtenerLibros(String nombre) {
        int i=0;
        while(!indice.get(i).getNombre().equals(nombre)){
            i++;
        }
        if(i==indice.size()){
            System.out.println("No hay libros con ese genero");
            return null;
        }else{
            LinkedList<Libro> libros = indice.get(i).getLibros();
            Iterator<Libro> it = libros.iterator();
            return it;
        }
    }

    public LinkedList<String> ObtenerGeneros() {
        LinkedList<String> tmp = new LinkedList<>();
        for (Genero genero : indice) {
            tmp.add(genero.getNombre());
        }
        return tmp;
    }

}