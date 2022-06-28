package tp;

public class Libro{
    private String nombre;
    private String autor;
    private int paginas;
    private String[] generos;

    public Libro(String nombre, String autor, int paginas, String[] generos){
        this.nombre = nombre;
        this.autor = autor;
        this.paginas = paginas;
        this.generos = generos;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getAutor(){
        return this.autor;
    }

    public int getPaginas(){
        return this.paginas;
    }

    public String[] getGeneros(){
        String[] tmp = this.generos;
        return tmp;
    }

    public String getGenero(int posicion){
        return generos[posicion];
    }

    public int getSize(){
        return this.generos.length;
    }
    
    public String toString(){
        return nombre+","+autor+","+paginas+","+generos.toString();
    }


}