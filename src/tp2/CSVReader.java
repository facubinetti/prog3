package tp2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "C:/Users/faku_/Desktop/Programacion/TP1/prog3/src/tp2/datasets/dataset.csv";
        String line = "";
        String cvsSplitBy = ",";
        Herramienta herramienta = new Herramienta();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) { // leo una linea 
                String[] items = line.split(cvsSplitBy); // spliteo la linea y guardo los datos por separado en un array de string
                herramienta.crearGrafo(items);
            }
            
        //    SERVICIO 1 BUSCADOR SIGUIENTEE GENERO MAYOR
            // LinkedList<String> listavertice = herramienta.masBuscado("informatica", 5);
            // for (String arco : listavertice) {
            //     System.out.println(arco);
            // }

            // SERVICIO 2 SECUENCIA MAYOR
            LinkedList<String> listavertice2 = herramienta.secuencia("fotografia");
            for (String vertice : listavertice2) {
                System.out.println(vertice.toString());
            }

            //    System.out.println(herramienta.grafo.toString());
  
            //SERVICIO 3 Grafo Afin a genero
            // GrafoDirigido<String> grafoAfin = new GrafoDirigido<String>();
            // grafoAfin = herramienta.generarAfines("ficcion");
		    // System.out.println(grafoAfin.toString());


            // CSVWritter csv = new CSVWritter(indice);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}