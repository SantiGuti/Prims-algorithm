package codigoNegocio;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import com.sun.tools.javac.util.Pair;

import grafos.Arista;
import grafos.GrafoConPeso;

public class generadorDeArbol {
	private GrafoConPeso grafo;
	private HashMap<String, Pair<Persona, Integer>> personas;
	private int indicePersona;
	
	public generadorDeArbol(int cantPersonas) {
		grafo = new GrafoConPeso(cantPersonas);
		personas = new HashMap<>();
		indicePersona = 0;
	}
	public void agregarPersona(Persona p) {
		if(indicePersona==grafo.size())
			throw new IllegalArgumentException("LA CAPACIDAD DEL GRAFO ES DE: "+grafo.size()+" PERSONAS");
		personas.put(p.getNombre(), new Pair<Persona, Integer>(p, indicePersona));
		indicePersona++;
	}
	public void agregarArista(String personaI, String personaJ) {
		grafo.agregarArista(personas.get(personaI).snd, 
		personas.get(personaJ).snd, personas.get(personaI).fst.indiceSimilaridad(personas.get(personaJ).fst));
	}
	
	private String personaToInteger(String persona) {
		return personas.get(persona).snd+"";
	}
	
	public void mst() {
		grafo = grafo.mst();
	}
	
	public void eliminarAristaMax() {
		grafo.eliminarAristaMax();
	}
	
	public HashSet<Arista> aristas(){
		return grafo.aristas();
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		String g = grafo.aristas().toString();
		for(Entry<String, Pair<Persona, Integer>> entry : personas.entrySet()) {
			g = g.replace(personaToInteger(entry.getKey()), entry.getKey());
		}
		s.append(g);
		return s.toString();
	}
}
