package grafos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class GrafoConPeso {
	private PriorityQueue<Arista> aristas;
	private final int cantVertices;
	private int cantAristas;
	private HashSet<Arista> aristasAgregadas;

	public GrafoConPeso(int vertices) {
		aristas = new PriorityQueue<>((Arista a1, Arista a2) -> a1.compareTo(a2));
		cantAristas = 0;
		cantVertices = vertices;
		aristasAgregadas = new HashSet<>();
	}
	
	public boolean agregarArista(int i, int j, Integer p) {
		Arista arista = new Arista(i, j, p);
		if(!aristasAgregadas.contains(arista)) {
			aristas.add(arista);
			aristasAgregadas.add(arista);	
			cantAristas++;
			return true;
		}
		return false;
	}
	
	public boolean agregarArista(Arista a) {
		if(!aristasAgregadas.contains(a)) {
			aristas.add(a);
			aristasAgregadas.add(a);
			cantAristas++;
			return true;
		}
		return false;
	}
	
	public GrafoConPeso mst() {
		GrafoConPeso mst = new GrafoConPeso(cantVertices);
		HashSet<Integer> setMst = new HashSet<>();
		Arista a = aristas.poll();
		setMst.add(a.getI());
		setMst.add(a.getJ());
		mst.agregarArista(a);
		while(mst.cantAristas<cantVertices-1) {
			Arista min = new Arista(0, 1, 99999);
			Iterator<Arista> it = aristas.iterator();
			while(it.hasNext()) {
				a = it.next();
				if((setMst.contains(a.getI()) && !setMst.contains(a.getJ())) || (setMst.contains(a.getJ()) && !setMst.contains(a.getI()))) {
					if(a.compareTo(min)<0) {
						min = a;
					}
				}
			}
			mst.agregarArista(min);
			setMst.add(min.getI());
			setMst.add(min.getJ());
		}
		return mst;
	}
	
	public PriorityQueue<Arista> getAristas(){
		return aristas;
	}
	
	public void eliminarAristaMax() {
		Iterator<Arista> it = aristas.iterator();
		Arista max = it.next();
		while(it.hasNext()) {
			Arista a = it.next();
			if(a.getPeso()>max.getPeso()) {
				max = a;
			}
		}
		aristas.remove(max);
	}
	
	public int size() {
		return cantVertices;
	}
	
	public HashSet<Arista> aristas(){
		HashSet<Arista> arist = new HashSet<>();
		arist.addAll(aristas);
		return arist;
	}
}
