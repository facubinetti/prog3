package tp2;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashSet<String> vertices;
	private HashSet<Arco> arcos;
	public GrafoDirigido() {
		this.vertices = new HashSet<String>();
		this.arcos = new HashSet<Arco>();
	}

	// Complejidad: O(1)
	@Override
	public void agregarVertice(String verticeId) {
		this.vertices.add(verticeId);
	}

	// Complejidad: O(n+a) donde n es el numero de vertices y a el numero de arcos
	@Override
	public void borrarVertice(String verticeId) {
		boolean deleted = false;
		Iterator<String> it = this.vertices.iterator();
		while (it.hasNext() && !deleted) {
			String next = it.next();
			if (next.equals(verticeId)) {
				Iterator<Arco> itArco = this.arcos.iterator();
				while (itArco.hasNext()) {
					Arco arco = itArco.next();
					if (arco.getVerticeOrigen().equals(verticeId) || arco.getVerticeDestino().equals(verticeId)) {
						itArco.remove();
					}
				}
				this.vertices.remove(next);
				deleted = true;
			}
		}
	}

	// Complejidad: O(1)
	@Override
	public void agregarArco(String verticeId1, String verticeId2, int etiqueta) {
		this.arcos.add(new Arco (verticeId1, verticeId2, etiqueta));
	}

	// Complejidad: O(n) donde n es el numero de arcos
	@Override
	public void borrarArco(String verticeId1, String verticeId2) {
		for (Arco arco : this.arcos) {
			if (arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2)) {
				this.arcos.remove(arco);
				break;
			}
		}
	}

	// Complejidad: O(n) donde n es el numero de vertices
	@Override
	public boolean contieneVertice(String verticeId) {
		for (String vertice : this.vertices) {
			if (vertice.equals(verticeId))
				return true;
		}
		return false;
	}

	// Complejidad: O(1) debido al hasCode y equals del hashset
	@Override
	public boolean existeArco(String verticeId1, String verticeId2) {
		for (Arco arco : arcos) {
			if(arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2)){
				return true;
			}
		}
		return false;
	}

	// Complejidad: O(n) donde n es el numero de arcos
	@Override
	public Arco obtenerArco(String verticeId1, String verticeId2) {
		for (Arco arco : this.arcos) {
			if (arco.getVerticeOrigen().equals(verticeId1) && arco.getVerticeDestino().equals(verticeId2))
				return arco;
		}
		return null;
	}

	// Complejidad: O(1)
	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	// Complejidad: O(1)
	@Override
	public int cantidadArcos() {
		return this.arcos.size();
	}

	// Complejidad: O(1)
	@Override
	public Iterator<String> obtenerVertices() {
		return this.vertices.iterator();
	}

	// Complejidad: O(n) donde n es el numero de arcos
	// el add dentro del if no suma porque es O(1)
	@Override
	public Iterator<String> obtenerAdyacentes(String verticeId) {
		LinkedList<String> resultado = new LinkedList<String>();
		for (Arco arco : this.arcos) {
			if (arco.getVerticeOrigen().equals(verticeId)) {
				resultado.add(arco.getVerticeDestino());
			}
		}
		return resultado.iterator();
	}

	// Complejidad: O(1)
	@Override
	public Iterator<Arco> obtenerArcos() {
		return this.arcos.iterator();
	}

	// Complejidad: O(n) donde n es el numero de arcos
	// el add dentro del if no suma porque es O(1)
	@Override
	public Iterator<Arco> obtenerArcos(String verticeId) {
		LinkedList<Arco> resultado = new LinkedList<Arco>();
		for (Arco arco : this.arcos) {
			if (arco.getVerticeOrigen().equals(verticeId)) {
				resultado.add(arco);
			}
		}
		return resultado.iterator();
	}

	@Override
	public String toString() {
		return "GrafoDirigido:\n" + "arcos=" + arcos + "\nvertices=" + vertices;
	}
	//Complejidad O(n) donde n es la cantidad de vertices
	public String obtenerVertice(String vertice){
		for (String v : vertices) {
			if (vertice.equals(v)){
				return v;
			}
		}
		return null;
	}


}