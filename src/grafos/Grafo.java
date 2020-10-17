package grafos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Grafo
{
	// Representamos el grafo por su matriz de adyacencia
	protected boolean[][] A;
	protected int[] cantVecinos;
	
	// La cantidad de vertices esta predeterminada desde el constructor
	public Grafo(int vertices)
	{
		A = new boolean[vertices][vertices];
		cantVecinos = new int[vertices];
	}
	
	// Agregado de aristas
	public void agregarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);
		
		cantVecinos[i]++;
		cantVecinos[j]++;
		A[i][j] = true;
		A[j][i] = true;
	}
	
	// Eliminacion de aristas
	public void eliminarArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		cantVecinos[i]--;
		cantVecinos[j]--;
		A[i][j] = false;
		A[j][i] = false;
	}

	// Informa si existe la arista especificada
	public boolean existeArista(int i, int j)
	{
		verificarVertice(i);
		verificarVertice(j);
		verificarDistintos(i, j);

		return A[i][j];
	}

	// Cantidad de vertices
	public int tamano()
	{
		return A.length;
	}
	
	// Vecinos de un vertice
	public Set<Integer> vecinos(int i)
	{
		verificarVertice(i);
		
		Set<Integer> ret = new HashSet<Integer>();
		for(int j = 0; j < this.tamano(); ++j) if( i != j )
		{
			if( this.existeArista(i,j) )
				ret.add(j);
		}
		
		return ret;		
	}
	
	// Verifica que sea un vertice valido
	protected void verificarVertice(int i)
	{
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	// Verifica que i y j sean distintos
	protected void verificarDistintos(int i, int j)
	{
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}

	public int[] getCantVecinos() {
		return cantVecinos;
	}
	public boolean esConexo() {
		HashSet<Integer> visitados = BFS(0);
		return (visitados.size()==A.length);
	}
	private HashSet<Integer> BFS(int s) 
    { 
        // Mark all the vertices as not visited(By default 
        // set as false) 
        HashSet<Integer> visitados = new HashSet<>();
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visitados.add(s);
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
  
            // Get all adjacent vertices of the dequeued vertex s 
            // If a adjacent has not been visited, then mark it 
            // visited and enqueue it 
            for(Integer vecinos:vecinos(s)) {
            	if(!visitados.contains(vecinos)) {
            		visitados.add(vecinos);
            		queue.add(vecinos);
            	}
            }
        }

        return visitados;
    }
	
	public boolean esUniversal(int v) {
		return (cantVecinos[v]>=A.length-1);
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		HashSet<String> agregados = new HashSet();
		s.append("Aristas: ");
		for(int i=0;i<A.length;i++) {
			for(int j=0;j<A.length;j++) {
				if(j!=i) {
					if(existeArista(i, j) && !agregados.contains(Integer.toString(i)+Integer.toString(j)) && !agregados.contains(Integer.toString(j)+Integer.toString(i))) {
						s.append(Integer.toString(i)+Integer.toString(j)+" ");
						agregados.add(Integer.toString(i)+Integer.toString(j));
					}
				}
			}
		}
		return s.toString();
	}
	
}
