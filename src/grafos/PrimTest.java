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
		assertTrue(grafo.mst().aristas().containsAll(arbolGenMin));
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
		assertTrue(arbolGenMin2.containsAll(grafo2.mst().aristas()));
	}
	
	@Test 
	public void testPrim3() {
		GrafoConPeso grafo3 = new GrafoConPeso(9);
		grafo3.agregarArista(0,1,4);
		grafo3.agregarArista(0,7,8);
		grafo3.agregarArista(1,7,12);
		grafo3.agregarArista(1,2,8);
		grafo3.agregarArista(7,6,1);
		grafo3.agregarArista(7,8,6);
		grafo3.agregarArista(6,8,5);
		grafo3.agregarArista(2,8,3);
		grafo3.agregarArista(2,3,6);
		grafo3.agregarArista(6,5,3);
		grafo3.agregarArista(2,5,4);
		grafo3.agregarArista(3,5,13);
		grafo3.agregarArista(3,4,9);
		grafo3.agregarArista(5,4,10);
		HashSet<Arista> arbolGenMin3 = new HashSet<>();
		arbolGenMin3.add(new Arista(0,1,4));
		arbolGenMin3.add(new Arista(1,2,8));
		arbolGenMin3.add(new Arista(2,8,3));
		arbolGenMin3.add(new Arista(2,5,4));
		arbolGenMin3.add(new Arista(2,3,6));
		arbolGenMin3.add(new Arista(3,4,9));
		arbolGenMin3.add(new Arista(6,5,3));
		arbolGenMin3.add(new Arista(7,6,1));
		assertTrue(grafo3.mst().aristas().containsAll(arbolGenMin3));
	}
	
	@Test 
	public void eliminarAristaMaxTest() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(0, 1, 2);
		grafo.agregarArista(0, 2, 4);
		grafo.agregarArista(1, 3, 5);
		grafo.agregarArista(1, 4, 3);
		grafo.agregarArista(3, 4, 6);
		grafo.agregarArista(2, 4, 1);
		grafo.eliminarAristaMax();
		assertFalse(grafo.aristas().contains(new Arista(3, 4, 6)));
	}
}
