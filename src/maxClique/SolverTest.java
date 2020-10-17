package maxClique;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import grafos.Assert;
import grafos.Grafo;

public class SolverTest
{
	@Test
	public void cliqueTresTest()
	{
		Solver solver = new Solver(trianguloConAntena());
		Set<Integer> obtenido = solver.resolver();
		
		int[] esperado = {0, 1, 2};
		Assert.iguales(esperado, obtenido);
	}	

	@Test
	public void aisladoTest()
	{
		Grafo aislado = new Grafo(5);
		
		Solver solver = new Solver(aislado);
		Set<Integer> obtenido = solver.resolver();
		
		assertEquals(1, obtenido.size());
	}	


	@Test
	public void completoTest()
	{
		Solver solver = new Solver(completo());
		Set<Integer> obtenido = solver.resolver();
		
		int[] esperado = {0, 1, 2, 3};
		Assert.iguales(esperado, obtenido);
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
	
	private Grafo completo()
	{
		Grafo grafo = new Grafo(4);
		grafo.agregarArista(0, 1);
		grafo.agregarArista(0, 2);
		grafo.agregarArista(0, 3);
		grafo.agregarArista(1, 2);
		grafo.agregarArista(1, 3);
		grafo.agregarArista(2, 3);
		
		return grafo;
	}
	
}
