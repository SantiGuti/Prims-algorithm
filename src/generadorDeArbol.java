import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
	
	private int personaToInteger(String persona) {
		return personas.get(persona).snd;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("(");
		for(Arista a:grafo.Aristas()) {
			s.append("[");
			for(Entry<String, Pair<Persona, Integer>> entry : personas.entrySet()) {
				int indicePersona = entry.getValue().snd;
				if(indicePersona==a.getI()) {
					s.append(entry.getKey());
				}
				if(indicePersona==a.getJ()) {
					s.append(entry.getKey());
				}
			}
			s.insert(s.length()-1, ", ");
			s.append("], ");
		}
		s.delete(s.length()-2, s.length());
		s.append(")");
		return s.toString();
	}
}
