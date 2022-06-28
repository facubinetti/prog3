package tp;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "C:/Users/faku_/Desktop/Programacion/TP1/prog3/src/tp/dataset4.csv";
        String line = "";
        String cvsSplitBy = ",";
        LinkedList<Libro> listaLibros = new LinkedList<Libro>();
        Libro libro;
        Indice indice = new Indice();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) { // leo una linea 
                String[] items = line.split(cvsSplitBy); // spliteo la linea y guardo los datos por separado en un array de string
                // records.add(Arrays.asList(items));
                    
                    String[] generos = items[3].split(" "); // creo un arreglo de los generos de un libro
                    libro = new Libro(items[0],items[1],Integer.parseInt(items[2]),generos); // creo libro
                    listaLibros.add(libro);

                // ---------------------------------------------
                // Poner el codigo para cargar los datos
                // ---------------------------------------------
            }

            for (Libro libro2 : listaLibros) {
                indice.agregarLibro(libro2);//lo agrego
            }

            CSVWritter writter = new CSVWritter();
            writter.writebyGenero(indice, "humor");

   
		    

            // CSVWritter csv = new CSVWritter(indice);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}