package tp2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class Herramienta {
    private GrafoDirigido<String> grafo;
    private HashMap<String, String> colores;
    private String verticeOrigen;
    private GrafoDirigido<String> grafoFinal = new GrafoDirigido<String>();
    private LinkedList<String> verticesparciales = new LinkedList<String>();

    public Herramienta() {
        this.grafo = new GrafoDirigido<String>();
        this.colores = new HashMap<String, String>();
    }

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

    public LinkedList<String> masBuscado(String genero, int n) {
        // la cantidad de vertices
        LinkedList<Arco> listaArcos = new LinkedList<Arco>();
        LinkedList<String> resultado = new LinkedList<String>();
        Iterator<Arco> arcos = grafo.obtenerArcos(genero); // obtengo todos los arcos del vertice // O(n) donde n es el
                                                           // numero de arcos
        listaArcos = ordenarArcos(arcos);

        int i = 0;
        while (i < n && i < listaArcos.size()) { // recorro la lista ordenada hasta N o hasta que termine la lista
                                                 // //complejidad O(n) donde n es N enviado por parametro o O(n) donde n
                                                 // es la cantidad total de arcos
            resultado.add("Genero: " + listaArcos.get(i).getVerticeDestino() + " -- Busquedas: "
                    + listaArcos.get(i).getEtiqueta()); // complejidad O(1) ya que linkedlist tiene guardado su ultimo
                                                        // elemento
            i++;
        }
        return resultado;
    }

    public LinkedList<String> secuencia(String genero) {
        this.verticeOrigen = genero; // Complejidad O(n) donde n es la cantidad de vertices
        LinkedList<String> resulta = new LinkedList<String>();
        resulta.add(verticeOrigen);
        resulta.addAll(SecuenciMayor(verticeOrigen));

        return resulta;
    }

    public LinkedList<String> SecuenciMayor(String vertice) {
        Iterator<Arco> arcos = grafo.obtenerArcos(vertice);
        LinkedList<String> resulta = new LinkedList<String>();
        LinkedList<Arco> listaArcos = new LinkedList<Arco>();
        boolean esorigen = false;
        if (arcos.hasNext()) {
            listaArcos = ordenarArcos(arcos); // ordeno arcos de mayor a menor
        }
        while (!listaArcos.isEmpty() && !esorigen) { // recorro la lista ordenada hasta que termine la lista o haya
                                                     // llegado al origen la complejidad es O(n) donde n es el numero de
                                                     // arcos del vertice actual
            Arco aux = listaArcos.removeFirst(); // tomo el arco mas grande
            if (!aux.getVerticeDestino().equals(this.verticeOrigen)) { // si el vertice actual no es igual al vertie
                                                                       // origen
                String auxV = aux.getVerticeDestino();
                resulta.add(auxV);
                resulta.addAll(SecuenciMayor(auxV));
                return resulta;
            } else { // si es igual esorigen true y retorno resultado
                esorigen = true;
                return resulta;
            }
        }
        return null;
    }

    public LinkedList<String> secuencia2 (String origen){
        this.verticeOrigen = origen;
        Iterator<String> allVertices = grafo.obtenerVertices();
        String vertice;
        // pongo todos los vertices en blanco
        while (allVertices.hasNext()) {
            vertice = allVertices.next();
            colores.put(vertice, "blanco");
        }
        LinkedList<String> fila = new LinkedList<String>();
        secuenciaMayor2(origen,fila);
        return this.verticesparciales;
    }

    public void secuenciaMayor2(String origen, LinkedList<String> fila) {
        colores.put(origen,"amarillo");
        this.verticesparciales.add(origen);
        fila.add(origen);
        boolean esorigen = false;
        while(!fila.isEmpty() && !esorigen){
            String aux = fila.removeFirst();
            Iterator<String> listady = grafo.obtenerAdyacentes(aux);
            Arco arcomayor = null;
            String adymayor=null;
            while (listady.hasNext()){
                String ady = listady.next();
                Arco arcoaux = grafo.obtenerArco(aux,ady);
                
                if(arcomayor == null || arcoaux.getEtiqueta()>arcomayor.getEtiqueta()){
                    arcomayor=arcoaux;
                    adymayor = arcomayor.getVerticeDestino();
                }
            }
            if(colores.get(arcomayor.getVerticeDestino()).equals("blanco")){
                colores.put(adymayor,"amarillo");
                this.verticesparciales.add(adymayor);
                fila.add(adymayor);
            }else if(!adymayor.equals(this.verticeOrigen)){
                esorigen = true;
            }
        }
    }




    public LinkedList<Arco> ordenarArcos(Iterator<Arco> itArcos) {
        LinkedList<Arco> listaArcos = new LinkedList<Arco>();
        while (itArcos.hasNext()) { // O(n) donde n es el numero de arcos
            listaArcos.add(itArcos.next()); // los agrego a una lista //Complejidad O(1) ya que linkedlist tiene
                                            // guardado su ultimo elemento
        }
        Collections.sort(listaArcos); //

        return listaArcos;
    }

    public GrafoDirigido<String> generarAfines(String origen) {
        this.verticeOrigen = origen;
        Iterator<String> allVertices = grafo.obtenerVertices();
        String vertice;
        // pongo todos los vertices en blanco
        while (allVertices.hasNext()) {
            vertice = allVertices.next();
            colores.put(vertice, "blanco");
        }
        dfsGenerar2(origen);
        return this.grafoFinal;
    }

    public void dfsGenerar2(String origen) {
        this.colores.put(origen, "amarillo"); // marco como vistado
        verticesparciales.add(origen); // agrego al camino parcial
        Iterator<String> ady = grafo.obtenerAdyacentes(origen);// obtengo los adyasentes de mi origen
        while (ady.hasNext()) {// recorro todos mis adyasentes
            String aux = ady.next();
            if (this.colores.get(aux).equals("blanco")) { // si no esta visitado llamo recursivamente a dfs
                dfsGenerar2(aux);
            } else if (this.colores.get(aux).equals("amarillo")) { // si esta visitado y es mi origen, cargo la
                                                                   // informacion en mi grafo
                if (aux.equals(this.verticeOrigen)) {
                    cargarGrafo();
                }
            }
        }
        verticesparciales.remove(origen); // remuevo este elemnto de mi camino
        this.colores.put(origen, "negro");// lo marco en negro para no visitarlo mas
    }

    public void cargarGrafo() {
        for (String vertice : verticesparciales) {
            this.grafoFinal.agregarVertice(vertice);
            for (String verticedestino : verticesparciales) {
                if (this.grafo.existeArco(vertice, verticedestino)) {
                    Arco esteArco = this.grafo.obtenerArco(vertice, verticedestino);
                    if (!this.grafoFinal.existeArco(vertice, verticedestino)) {
                        this.grafoFinal.agregarArco(vertice, verticedestino, esteArco.getEtiqueta());
                    }
                }
            }
        }
    }
}
