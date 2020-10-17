package maxClique;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import grafos.Grafo;

public class AuxiliaresTest
{
	@Test
	public void todosAisladosTest()
	{
		int[] C = {2, 3, 4};
		Grafo aislado = new Grafo(5);
		
		assertFalse(Auxiliares.esClique(aislado, toSet(C)));
	}

	@Test
	public void vacioTest()
	{
		int[] C = {};
		Grafo aislado = new Grafo(5);

		assertTrue(Auxiliares.esClique(aislado, toSet(C)));
	}
	
	@Test
	public void trianguloTest()
	{
		int[] C = {0, 1, 2};
		Grafo grafo = trianguloConAntena();

		assertTrue(Auxiliares.esClique(grafo, toSet(C)));
	}
	
	@Test
	public void noTrianguloTest()
	{
		int[] C = {0, 1, 3};
		Grafo grafo = trianguloConAntena();
		
		assertFalse(Auxiliares.esClique(grafo, toSet(C)));
	}
	
	@Test
	public void aristaTest()
	{
		int[] C = {1, 3};
		Grafo grafo = trianguloConAntena();

		assertTrue(Auxiliares.esClique(grafo, toSet(C)));
	}

	private Grafo trianguloConAntena()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(3, 1);
		
		return grafo;
	}
	
	private Set<Integer> toSet(int[] valores)
	{
		Set<Integer> ret = new HashSet<Integer>();
		for(Integer v: valores)
			ret.add(v);
		
		return ret;
	}
}
