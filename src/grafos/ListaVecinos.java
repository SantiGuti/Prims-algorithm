package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class ListaVecinos {
	protected ArrayList<HashSet<Integer>> vecinos;
	private int cantAristas;
	
	public ListaVecinos(int vertices) {
		vecinos = new ArrayList<>(vertices);
		cantAristas = 0;
		for(int i=0;i<vertices;i++)
			vecinos.add(new HashSet<Integer>());
	}
	
	public int size() {
		return vecinos.size();
	}
	
	public void agregarArista(int i, int j) {
		cantAristas++;
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		vecinos.get(i).add(j);
		vecinos.get(j).add(i);
	}
	
	public void agregarArista(Arista a) {
		cantAristas++;
		verificarVertice(a.getI());
		verificarVertice(a.getJ());
		verificarDistintos(a.getI(), a.getJ());
		vecinos.get(a.getI()).add(a.getJ());
		vecinos.get(a.getJ()).add(a.getI());
	} 
	
	public int cantAristas() {
		return cantAristas;
	}
	
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);
	}
	
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return(vecinos.get(i).contains(j) && vecinos.get(j).contains(i));
	}
	
	public HashSet<Integer> vecinos(int i) {
		verificarVertice(i);
		return vecinos.get(i);
	}
	
	public ArrayList<HashSet<Integer>> getVecinos() {
		return vecinos;
	}
	
	public HashSet<Integer> BFS(int s) 
    { 

        HashSet<Integer> visitados = new HashSet<>();
  
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        visitados.add(s);
        queue.add(s); 
  
        while (queue.size() != 0) { 
            s = queue.poll(); 
            for(Integer vecino:vecinos(s)) {
            	if(!visitados.contains(vecino)) {
            		visitados.add(vecino);
            		queue.add(vecino);
            	}
            }
        }

        return visitados;
    }
	
	public int cantTriangulos() { 
		int cantTriangulos=0;
		int s=0;
		Set<Integer> vecinosAnteriores = vecinos(s);
		vecinosAnteriores.add(0);
        HashSet<Integer> visitados = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        visitados.add(s);
        queue.add(s); 
  
        while (queue.size() != 0) { 
        	int vecinosCoinciden = 0;
            s = queue.poll();  
            Set<Integer> vecinos = vecinos(s);
            vecinos.add(s);
            for(Integer vecino:vecinos) {
            	if(!visitados.contains(vecino)) {
            		visitados.add(vecino);
            		queue.add(vecino);
            	}
            	if(vecinosAnteriores.contains(vecino) && s>0) {
            		vecinosCoinciden++;
            	}
            }
            if(vecinosCoinciden>=3) {
            	cantTriangulos++;
            } 	
            vecinosAnteriores = vecinos(s);
            vecinosAnteriores.add(s);
        }
        return cantTriangulos;
    }
	
	public boolean esUniversal(int v) {
		return (vecinos(v).size()>=this.vecinos.size()-1);
	}
	
	public boolean distancia2(int v1, int v2) {
		verificarVertice(v1);
		verificarVertice(v2);
		if(existeArista(v1, v2))
			return false;
		Set<Integer> interseccion = vecinos(v1);
		interseccion.retainAll(vecinos(v2));
		return (!interseccion.isEmpty());
	}
	
	protected void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= vecinos.size() )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	protected void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		HashSet<String> repetidos = new HashSet<>();
		for(int i=0;i<vecinos.size();i++) {
			for(Integer v:vecinos.get(i)) {
				if(!repetidos.contains(i+v.toString()) && !repetidos.contains(v.toString()+i)) {
					s.append(i+v.toString());
					s.append(", ");
					repetidos.add(i+v.toString());
				}
			}
		}
		return s.toString();
	}
	
	public HashSet<Arista> aristas() {
		HashSet<Arista> s = new HashSet<>();
		HashSet<String> repetidos = new HashSet<>();
		for(int i=0;i<vecinos.size();i++) {
			for(Integer v:vecinos.get(i)) {
				if(!repetidos.contains(i+v.toString()) && !repetidos.contains(v.toString()+i)) {
					s.add(new Arista(i, v, 0));
					repetidos.add(i+v.toString());
				}
			}
		}
		return s;
	}
}
