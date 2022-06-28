package tp2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "C:/Users/faku_/Desktop/Programacion/TP1/prog3/src/tp2/datasets/dataset4.csv";
        String line = "";
        String cvsSplitBy = ",";
        Herramienta herramienta = new Herramienta();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) { // leo una linea 
                String[] items = line.split(cvsSplitBy); // spliteo la linea y guardo los datos por separado en un array de string
                // records.add(Arrays.asList(items));
                herramienta.crearGrafo(items);
                // ---------------------------------------------
                // Poner el codigo para cargar los datos
                // ---------------------------------------------
            }
            
           //SERVICIO 1 BUSCADOR SIGUIENTEE GENERO MAYOR
            LinkedList<String> listaArcos = herramienta.masBuscado("informatica", 5);
            for (String arco : listaArcos) {
                System.out.println(arco);
            }

        //    System.out.println(herramienta.grafo.toString());
            // CSVWritter writter = new CSVWritter();
   

   
		    

            // CSVWritter csv = new CSVWritter(indice);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}