package tp;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class CSVWritter {

	public CSVWritter() {
	}

	public void writebyGenero(Indice i, String nombre) {
		BufferedWriter bw = null;
		try {
			File file = new File("C:/Users/faku_/Desktop/Programacion/TP1/prog3/src/tp/datasets/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			// // Escribo la primer linea del archivo
			// String contenidoLinea1 = "Libro1,Autor,Paginas";
			// bw.write(contenidoLinea1);
			// bw.newLine();

			// // // Escribo la segunda linea del archivo
			// String contenidoLinea2 = "Usuario2,Tiempo2";
			// bw.write(contenidoLinea2);
			// bw.newLine();

			Iterator<Libro> libros = i.ObtenerLibros(nombre);
			while (libros.hasNext()) {
				Libro libroAct = libros.next();
				String contenidoLinea = libroAct.getNombre() + "," + libroAct.getAutor();
				System.out.println(contenidoLinea);
				bw.write(contenidoLinea);
				bw.newLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}