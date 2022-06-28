package tp;
import java.util.LinkedList;

public class Genero {
    private String nombre;
    private LinkedList<Libro> libros;


    public Genero( String name ){
        this.nombre = name;
        this.libros = new LinkedList<Libro>();
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void addLibro(Libro o){
        this.libros.add(o);
    }

    public LinkedList<Libro> getLibros(){      
        return this.libros;
    }
    


    public boolean esIgual(String nom){
        return this.nombre.equals(nom);
    }

}

