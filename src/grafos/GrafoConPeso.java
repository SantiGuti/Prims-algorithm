package grafos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class GrafoConPeso extends ListaVecinos{
	private PriorityQueue<Arista>[] aristas;

	public GrafoConPeso(int vertices) {
		super(vertices);
		aristas = new PriorityQueue[vecinos.size()];
		for(int i=0;i<vecinos.size();i++)
				aristas[i] = new PriorityQueue<>((Arista a1, Arista a2) -> a1.compareTo(a2));
	}
	
	public void agregarArista(int i, int j, Integer p) {
		agregarArista(i, j);
		aristas[i].add(new Arista(i, j, p));
		aristas[j].add(new Arista(i, j, p));
	}
	
	
	public ListaVecinos mst() {
		ListaVecinos mst = new ListaVecinos(vecinos.size());
		HashSet<Integer> visitados = new HashSet<>();
		Arista a=new Arista(1, 0, 3);
		while(mst.cantAristas()<vecinos.size()-1) {
			visitados.add(a.getJ());
			Iterator<Integer> it = visitados.iterator();
			a=new Arista(0, 1, 9999);
			while(it.hasNext()) {
				int i=it.next();
				System.out.println(visitados);
				if(!visitados.contains(aristas[i].peek().getI()) || !visitados.contains(aristas[i].peek().getJ()) && aristas[i].peek().getPeso()<a.getPeso()) {
					a=aristas[i].peek();
				}
			}
			mst.agregarArista(a);
			aristas[a.getI()].poll();
			aristas[a.getJ()].poll();
		}
		return mst;
	}
	
}
