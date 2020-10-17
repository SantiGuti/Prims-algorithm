package grafos;

import java.util.HashSet;
import java.util.PriorityQueue;

public class test {

	public static void main(String[] args) {
		
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(0, 1, 2);
		grafo.agregarArista(0, 2, 4);
		grafo.agregarArista(1, 3, 5);
		grafo.agregarArista(1, 4, 3);
		grafo.agregarArista(3, 4, 6);
		grafo.agregarArista(2, 4, 1);                                                                 
		//System.out.println(grafo.mst());
		GrafoConPeso grafo2 = new GrafoConPeso(5);
		grafo2.agregarArista(0, 1, 6);
		grafo2.agregarArista(0, 2, 1);//primero
		grafo2.agregarArista(1, 3, 2);//segundo
		grafo2.agregarArista(1, 4, 4);
		grafo2.agregarArista(3, 4, 3);//tercero
		grafo2.agregarArista(2, 4, 5);
		System.out.println(grafo2.mst());
		
	}

}
