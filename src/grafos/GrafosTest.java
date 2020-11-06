package grafos;

import codigoNegocio.Persona;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Test;

public class GrafosTest {
		private Persona p0=new Persona("0",1,1,1,1);
		private Persona p1=new Persona("1",1,1,1,1);
		private Persona p2=new Persona("2",1,1,1,1);
		private Persona p3=new Persona("3",1,1,1,1);
		private Persona p4=new Persona("4",1,1,1,1);
		private Persona p5=new Persona("5",1,1,1,1);
		private Persona p6=new Persona("6",1,1,1,1);
		private Persona p7=new Persona("7",1,1,1,1);
		private Persona p8=new Persona("8",1,1,1,1);

	@Test
	public void testPrim1() {
		GrafoConPeso grafo = new GrafoConPeso(5);
		grafo.agregarArista(p0, p1, 2);
		grafo.agregarArista(p0, p2, 4);
		grafo.agregarArista(p1, p3, 5);
		grafo.agregarArista(p1, p4, 3);
		grafo.agregarArista(p3, p4, 6);
		grafo.agregarArista(p2, p4, 1);
		HashSet<Arista> arbolGenMin = new HashSet<>();
		arbolGenMin.add(new Arista(p2, p4, 1));
		arbolGenMin.add(new Arista(p1, p4, 3));
		arbolGenMin.add(new Arista(p0, p1, 2));
		arbolGenMin.add(new Arista(p1, p3, 5));
		assertTrue(grafo.mst().containsAll(arbolGenMin));
	}

	@Test
	public void testPrim2() {
		GrafoConPeso grafo2 = new GrafoConPeso(5);
		grafo2.agregarArista(p0, p1, 6);
		grafo2.agregarArista(p0, p2, 1);
		grafo2.agregarArista(p1, p3, 2);
		grafo2.agregarArista(p1, p4, 4);
		grafo2.agregarArista(p3, p4, 3);
		grafo2.agregarArista(p2, p4, 5);
		HashSet<Arista> arbolGenMin2 = new HashSet<>();
		arbolGenMin2.add(new Arista(p0, p2, 1));
		arbolGenMin2.add(new Arista(p1, p3, 2));
		arbolGenMin2.add(new Arista(p2, p4, 5));
		arbolGenMin2.add(new Arista(p3, p4, 3));
		assertTrue(grafo2.mst().containsAll(arbolGenMin2));
	}
	
	@Test 
	public void testPrim3() {
		GrafoConPeso grafo3 = new GrafoConPeso(9);
		grafo3.agregarArista(p0,p1,4);
		grafo3.agregarArista(p0,p7,8);
		grafo3.agregarArista(p1,p7,12);
		grafo3.agregarArista(p1,p2,8);
		grafo3.agregarArista(p7,p6,1);
		grafo3.agregarArista(p7,p8,6);
		grafo3.agregarArista(p6,p8,5);
		grafo3.agregarArista(p2,p8,3);
		grafo3.agregarArista(p2,p3,6);
		grafo3.agregarArista(p6,p5,3);
		grafo3.agregarArista(p2,p5,4);
		grafo3.agregarArista(p3,p5,13);
		grafo3.agregarArista(p3,p4,9);
		grafo3.agregarArista(p5,p4,10);
		HashSet<Arista> arbolGenMin3 = new HashSet<>();
		arbolGenMin3.add(new Arista(p0,p1,4));
		arbolGenMin3.add(new Arista(p1,p2,8));
		arbolGenMin3.add(new Arista(p2,p8,3));
		arbolGenMin3.add(new Arista(p2,p5,4));
		arbolGenMin3.add(new Arista(p2,p3,6));
		arbolGenMin3.add(new Arista(p3,p4,9));
		arbolGenMin3.add(new Arista(p6,p5,3));
		arbolGenMin3.add(new Arista(p7,p6,1));
		assertTrue(grafo3.mst().containsAll(arbolGenMin3));
	}
	
}
