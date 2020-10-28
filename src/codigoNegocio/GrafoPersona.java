package codigoNegocio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import com.sun.tools.javac.util.Pair;

import grafos.Arista;
import grafos.GrafoConPeso;

public class GrafoPersona {
	private GrafoConPeso grafo;
	private ArrayList<Persona> personas;
	private int indicePersona;
	
	public GrafoPersona(int cantPersonas) {
		grafo = new GrafoConPeso(cantPersonas);
		personas = new ArrayList<>(cantPersonas);
		indicePersona = 0;
	}
	public void agregarPersona(Persona p) {
		if(indicePersona==grafo.size())
			throw new IllegalArgumentException("LA CAPACIDAD DEL GRAFO ES DE: "+grafo.size()+" PERSONAS");
		personas.add(p);
		for(int i=0;i<indicePersona;i++) {
			
			agregarArista(indicePersona, i);
		}
		indicePersona++;
	}
	
	private boolean agregarArista(int I, int J) {
		Persona personaI = personas.get(I);
		Persona personaJ = personas.get(J);
		if(!personaI.equals(personaJ)) {
			grafo.agregarArista(new Arista(I, J, personaI.indiceSimilaridad(personaJ)));
			return true;
		}
		return false;
	}
	
	public int size() {
		return grafo.size();
	}
	
	public void mst() {
		grafo = grafo.mst();
	}
	
	public void eliminarAristaMax() {
		grafo.eliminarAristaMax();
	}
	
	public HashSet<Pair<Persona, Persona>> aristas(){
		HashSet<Pair<Persona, Persona>> aristas=new HashSet<>();
		for(Arista a:grafo.aristas()) {
			aristas.add(new Pair<Persona, Persona>(personas.get(a.getI()), personas.get(a.getJ())));
		}
		return aristas;
	}
	
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		HashSet<Arista> aristas = grafo.aristas();
		s.append("[");
		for(Arista a:aristas) {
			s.append("["+personas.get(a.getI()).toString()+", ");
			s.append(personas.get(a.getJ()).toString()+"]");
		}
		s.append("]");
		return s.toString();
	}
}
