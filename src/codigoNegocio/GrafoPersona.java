package codigoNegocio;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import grafos.Arista;
import grafos.GrafoConPeso;
import grafos.MaxHashSet;


public class GrafoPersona {
	private GrafoConPeso grafo;
	private HashMap<String, Persona> verticePersonas;
	
	public GrafoPersona(int cantPersonas) {
		grafo = new GrafoConPeso(cantPersonas);
		verticePersonas = new HashMap<>();
	}
	
	public void agregarPersona(Persona p) {
		verticePersonas.put(p.toString(), p);
		for (Entry<String, Persona> entry : verticePersonas.entrySet()) {
			Persona persona = entry.getValue();
			if(!persona.equals(p)) {
				agregarArista(p, persona);
			}
		}
	}
	
	private boolean agregarArista(Persona I, Persona J) {
		if(!I.equals(J)) {
			grafo.agregarArista(I, J, I.indiceSimilaridad(J));
			return true;
		}
		return false;
	}
	
	public int size() {
		return grafo.size();
	}
	
	public MaxHashSet mst() {
		return grafo.mst();
	}
	
	public HashSet<Arista> aristas(){
		return grafo.aristas();
	}
	
}
