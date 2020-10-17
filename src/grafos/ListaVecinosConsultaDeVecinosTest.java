package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListaVecinosConsultaDeVecinosTest {
	@Test(expected = IllegalArgumentException.class)
	public void verticeNegativoTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.vecinos(-1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void verticeExcedidoTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.vecinos(5);
	}

	@Test
	public void todosAisladosTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		assertEquals(0, grafo.vecinos(2).size());
	}
	
	@Test
	public void verticeUniversalTest()
	{
		ListaVecinos grafo = new ListaVecinos(4);
		grafo.agregarArista(1, 0);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		
		int[] esperado = {0, 2, 3};
		Assert.iguales(esperado, grafo.vecinos(1));
	}
	
	@Test
	public void verticeNormalTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 4);
		
		int[] esperados = {1, 2};
		Assert.iguales(esperados, grafo.vecinos(3));
	}
	
	@Test 
	public void esUniversalTest() {
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(3, 4);
		
		assertTrue(grafo.esUniversal(1));
	}
	
	public void noEsUniversalTest() {
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(3, 4);
		
		assertFalse(grafo.esUniversal(2));
	}
	
	@Test
	public void distancia2() {
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(3, 4);
		
		assertTrue(grafo.distancia2(0, 3));
	}
	
	@Test
	public void noEsDistancia2() {
		ListaVecinos grafo = new ListaVecinos(6);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(1, 4);
		grafo.agregarArista(2, 4);
		grafo.agregarArista(3, 4);
		grafo.agregarArista(4, 5);
		
		assertFalse(grafo.distancia2(0, 5));
	}
}
