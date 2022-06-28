package tp2;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

public class Herramienta {
    GrafoDirigido<String> grafo = new GrafoDirigido<String>();

    public void crearGrafo(String[] lista) {
        String aux = null;
        for (String vertice : lista) { // O(n) donde n son los generos de la linea (vertices);
            if (!grafo.contieneVertice(vertice)) { // O(n) donde n es el numero de vertices
                grafo.agregarVertice(vertice); // O(1)
                if (aux != null) {
                    if (!grafo.existeArco(aux, vertice)) { // O(n) donde n es el numero de arcos total del grafo
                        grafo.agregarArco(aux, vertice, 1); // O(1)
                    }
                }
            } else if (aux != null) {
                if (grafo.existeArco(aux, vertice)) { // O(n) donde n es el numero de arcos total del grafo
                    Arco auxarco = grafo.obtenerArco(aux, vertice); // O(n) donde n es el numero de arcos total del
                                                                    // grafo
                    auxarco.sumEtiqueta();
                } else {
                    String verticeaux = grafo.obtenerVertice(vertice); // O(n) donde n es el numero de vertices
                    grafo.agregarArco(aux, verticeaux, 1); // O(1)
                }
            }
            aux = vertice;
        }
    }

    public LinkedList<String> masBuscado (String genero,int n){
        String vertice = grafo.obtenerVertice(genero);
        LinkedList<Arco> listaArcos = new LinkedList<Arco>();
        LinkedList<String> resultado = new LinkedList<String>();
        
            Iterator<Arco> arcos = grafo.obtenerArcos(vertice); //obtengo todos los arcos del vertice
            while (arcos.hasNext()){
                listaArcos.add(arcos.next()); // los agrego a una lista
            }
            Collections.sort(listaArcos); // ordeno la lista de arcos
            int i = 0;
            while (i<n && i<listaArcos.size()){ //recorro la lista ordenada hasta N o hasta que termine la lista
                // System.out.println(listaArcos.get(i).getVerticeDestino());
                resultado.add(listaArcos.get(i).getVerticeDestino()+" " +listaArcos.get(i).getEtiqueta());
                i++; 
             }

            return resultado;
    }

}
