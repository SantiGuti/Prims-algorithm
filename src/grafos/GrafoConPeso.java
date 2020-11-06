package grafos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;

import codigoNegocio.Persona;

public class GrafoConPeso {
	private PriorityQueue<Arista> aristas;
	private final int cantVertices;
	private HashSet<Arista> aristasAgregadas;

	public GrafoConPeso(int vertices) {
		aristas = new PriorityQueue<>((Arista a1, Arista a2) -> a1.compareTo(a2));
		cantVertices = vertices;
		aristasAgregadas = new HashSet<>();
	}
	
	public boolean agregarArista(Persona i, Persona j, Integer p) {
		Arista arista = new Arista(i, j, p);
		if(!aristasAgregadas.contains(arista)) {
			aristas.add(arista);
			aristasAgregadas.add(arista);	
			return true;
		}
		return false;
	}
	
	public boolean agregarArista(Arista a) {
		if(!aristasAgregadas.contains(a)) {
			aristas.add(a);
			aristasAgregadas.add(a);
			return true;
		}
		return false;
	}
	
	public HashSet<Arista> mst() {
		HashSet<Arista> mst = new HashSet<>(cantVertices);
		HashSet<Persona> setMst = new HashSet<>();
		Arista a = aristas.poll();
		setMst.add(a.getI());
		setMst.add(a.getJ());
		mst.add(a);
		while(mst.size()<cantVertices-1) {
			Arista min = new Arista(new Persona("a",1,1,1,1), new Persona("b",1,1,1,1), 99999);
			Iterator<Arista> it = aristas.iterator();
			while(it.hasNext()) {
				a = it.next();
				if((setMst.contains(a.getI()) && !setMst.contains(a.getJ())) || (setMst.contains(a.getJ()) && !setMst.contains(a.getI()))) {
					if(a.compareTo(min)<0) {
						min = a;
					}
				}
			}
			mst.add(min);
			setMst.add(min.getI());
			setMst.add(min.getJ());
		}
		return mst;
	}
	
	public int size() {
		return cantVertices;
	}
	
	public HashSet<Arista> aristas(){
		return aristasAgregadas;
	}
}
