package tp2;

/*
 * La clase arco representa un arco del grafo. Contiene un vertice origen, un vertice destino y una etiqueta.
 * Nota: Para poder exponer los arcos fuera del grafo y que nadie los modifique se hizo esta clase inmutable
 * (Inmutable: una vez creado el arco no es posible cambiarle los valores).
 */
public class Arco implements Comparable<Arco> {
    private String verticeDestino;
    private String verticeOrigen;
    private int etiqueta;

    public Arco(String verticeOrigen, String verticeDestino, int etiqueta) {
        this.verticeOrigen = verticeOrigen;
        this.verticeDestino = verticeDestino;
        this.etiqueta = etiqueta;
    }

    public String getVerticeOrigen() {
        return verticeOrigen;
    }

    public String getVerticeDestino() {
        return verticeDestino;
    }

    public int getEtiqueta() {
        return etiqueta;
    }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + verticeDestino;
    //     result = prime * result + verticeOrigen;
    //     return result;
    // }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arco other = (Arco) obj;
        if (verticeDestino != other.verticeDestino)
            return false;
        if (verticeOrigen != other.verticeOrigen)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "\n\tArco [etiqueta: " + etiqueta + ", verticeOrigen: "
                + verticeOrigen + ", verticeDestino: " + verticeDestino
                + "]";
    }

    public void sumEtiqueta() {
        this.etiqueta++;
    }

    @Override
    public int compareTo(Arco o) {
        if (this.etiqueta > o.etiqueta) {
            return -1;
        } else if (this.etiqueta < o.etiqueta) {
            return 1;
        } else {
            return 0;
        }
    }

}