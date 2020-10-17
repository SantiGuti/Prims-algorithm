package grafos;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class PrimTest {

	@Test
	public void testPrim1() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(0, 1, 2);
		grafo.agregarArista(0, 2, 4);
		grafo.agregarArista(1, 3, 5);
		grafo.agregarArista(1, 4, 3);
		grafo.agregarArista(3, 4, 6);
		grafo.agregarArista(2, 4, 1);
		HashSet<Arista> arbolGenMin = new HashSet<>();
		arbolGenMin.add(new Arista(0, 1, 2));
		arbolGenMin.add(new Arista(1, 3, 5));
		arbolGenMin.add(new Arista(1, 4, 3));
		arbolGenMin.add(new Arista(2, 4, 1));
		assertTrue(grafo.mst().Aristas().containsAll(arbolGenMin));
	}

	@Test
	public void testPrim2() {
		GrafoConPeso grafo2 = new GrafoConPeso(5);
		grafo2.agregarArista(0, 1, 6);
		grafo2.agregarArista(0, 2, 1);
		grafo2.agregarArista(1, 3, 2);
		grafo2.agregarArista(1, 4, 4);
		grafo2.agregarArista(3, 4, 3);
		grafo2.agregarArista(2, 4, 5);
		HashSet<Arista> arbolGenMin2 = new HashSet<>();
		arbolGenMin2.add(new Arista(0, 2, 6));
		arbolGenMin2.add(new Arista(1, 3, 2));
		arbolGenMin2.add(new Arista(2, 4, 5));
		arbolGenMin2.add(new Arista(3, 4, 3));
		assertTrue(grafo2.mst().Aristas().containsAll(arbolGenMin2));
	}
}
