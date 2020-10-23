package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class GrafoConPeso extends ListaVecinos{
	private LinkedList<Arista> aristas;

	public GrafoConPeso(int vertices) {
		super(vertices);
		aristas = new LinkedList();
	}
	
	public void agregarArista(int i, int j, Integer p) {
		agregarArista(i, j);
		aristas.add(new Arista(i, j, p));
	}
	
	@Override
	public void agregarArista(Arista a) {
		agregarArista(a.getI(), a.getJ());
		aristas.add(a);
	}
	
	public GrafoConPeso mst() {
		GrafoConPeso mst = new GrafoConPeso(vecinos.size());
		HashSet<Integer> setMst = new HashSet<>();
		Arista a = aristas.poll();
		setMst.add(a.getI());
		setMst.add(a.getJ());
		mst.agregarArista(a);
		while(mst.cantAristas()<vecinos.size()-1) {
			Arista min = new Arista(0, 1, 99999);
			Iterator<Arista> it = aristas.iterator();
			Iterator<Arista> itSave = aristas.iterator();
			while(it.hasNext()) {
				a = it.next();
				if((setMst.contains(a.getI()) && !setMst.contains(a.getJ())) || (setMst.contains(a.getJ()) && !setMst.contains(a.getI()))) {
					if(a.compareTo(min)<0) {
						min = a;
						itSave = it;
					}
				}
			}
			mst.agregarArista(min);
			setMst.add(min.getI());
			setMst.add(min.getJ());
			itSave.remove();
		}
		return mst;
	}
	
	public void eliminarAristaMax() {
		Iterator<Arista> it = aristas.iterator();
		Arista max = it.next();
		int posSave=0;
		int pos=0;
		while(it.hasNext()) {
			Arista a = it.next();
			if(a.getPeso()>max.getPeso()) {
				max = a;
				posSave=pos;
			}
			pos++;
		}
		aristas.remove(pos);
		eliminarArista(max.getI(), max.getJ());
	}
	
	@Override 
	public HashSet<Arista> aristas(){
		HashSet<Arista> arist = new HashSet<>();
		arist.addAll(aristas);
		return arist;
	}
}
