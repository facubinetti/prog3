package tp2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {
    public static void main(String[] args) {
        long inicioTotal = System.currentTimeMillis();
        long inicio = System.currentTimeMillis();
        String csvFile = "C:/Users/faku_/Desktop/Programacion/TP1/prog3/src/tp2/datasets/dataset1.csv";
        String line = "";
        String cvsSplitBy = ",";
        Herramienta herramienta = new Herramienta();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine();
            while ((line = br.readLine()) != null) { // leo una linea 
                String[] items = line.split(cvsSplitBy); // spliteo la linea y guardo los datos por separado en un array de string
                herramienta.crearGrafo(items);
            }
            long fin = System.currentTimeMillis();
            double tiempografo = (double) ((fin - inicio)) / 1000;


            //SERVICIO 1 BUSCADOR SIGUIENTEE GENERO MAYOR
            // inicio del timer
            inicio = System.currentTimeMillis();
            System.out.println("---------------------SERVICIO 1---------------------");
            LinkedList<String> listavertice = herramienta.masBuscado("informatica", 5);
            for (String arco : listavertice) {
                System.out.println(arco);
            }
            fin = System.currentTimeMillis();
            double tiempoS1 = (double) ((fin - inicio)) / 1000;

            // SERVICIO 2 SECUENCIA MAYOR *SE ROMPE CON EL DATASET 4*;
            // inicio del timer
//            inicio = System.currentTimeMillis();

            // LinkedList<String> listavertice2 = herramienta.secuencia("poesia");
            // for (String vertice : listavertice2) {
            //     System.out.println(vertice.toString());
            // }
//            fin = System.currentTimeMillis();
//            double tiempoS2 = (double) ((fin - inicio)/1000);

            // SERVICIO 2 SECUENCIA MAYOR
            // inicio del timer
            inicio = System.currentTimeMillis();
            System.out.println("---------------------SERVICIO 2---------------------");
            //llamado e impresion del resultado del servicio 2
            LinkedList<String> listavertice2 = herramienta.secuencia2("poesia");
            for (String vertice : listavertice2) {
                System.out.println(vertice.toString());
            }
            //fin del timer
            fin = System.currentTimeMillis();
            double tiempoS2 = (double) ((fin - inicio)) / 1000;

            //    System.out.println(herramienta.grafo.toString());

            //SERVICIO 3 Grafo Afin a genero

            // inicio del timer
            inicio = System.currentTimeMillis();
            System.out.println("---------------------SERVICIO 3---------------------");
            GrafoDirigido<String> grafoAfin = new GrafoDirigido<String>();
            grafoAfin = herramienta.generarAfines("poesia");
            System.out.println(grafoAfin.toString());

            fin = System.currentTimeMillis();
            double tiempoS3 = (double) ((fin - inicio)) / 1000;


            long finTotal = System.currentTimeMillis();
            double tiempoTotal = (double) ((finTotal - inicioTotal)) / 1000;

            System.out.println(tiempografo + " segundos para crear el grafo");
            System.out.println(tiempoS1 + " segundos para servicio 1");
            System.out.println(tiempoS2 + " segundos para servicio 3");
            System.out.println(tiempoS3 + " segundos para servicio 3");
            System.out.println(tiempoTotal + " segundos el total de las operaciones");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}