package grafos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListaVecinosEdicionDeAristasTest {
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(-1, 3);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeExcedidoTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(5, 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, -1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeExcedidoTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void agregarLoopTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 2);
	}

	@Test
	public void aristaExistenteTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 3);
		assertTrue( grafo.existeArista(2, 3) );
	}

	@Test
	public void aristaOpuestaTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 3);
		assertTrue( grafo.existeArista(3, 2) );
	}

	@Test
	public void aristaInexistenteTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 3);
		assertFalse( grafo.existeArista(1, 4) );
	}

	@Test
	public void agregarAristaDosVecesTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 3);
		grafo.agregarArista(2, 3);

		assertTrue( grafo.existeArista(2, 3) );
	}
	
	@Test
	public void eliminarAristaExistenteTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 4);
		
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}

	@Test
	public void eliminarAristaInexistenteTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}
	
	@Test
	public void eliminarAristaDosVecesTest()
	{
		ListaVecinos grafo = new ListaVecinos(5);
		grafo.agregarArista(2, 4);
		
		grafo.eliminarArista(2, 4);
		grafo.eliminarArista(2, 4);
		assertFalse( grafo.existeArista(2, 4) );
	}

}
