package codigoNegocio;

import java.util.ArrayList;
import java.util.HashSet;

import com.sun.tools.javac.util.Pair;

public class GenerarArbolPersona {
	private ArrayList<Persona> personas;
	private HashSet<Persona> grupoA;
	private HashSet<Persona> grupoB;
	
	public GenerarArbolPersona() {
		personas=new ArrayList<>();
		grupoA = new HashSet<>();
		grupoB = new HashSet<>();
	}
	
	public void agregarPersona(Persona p) {
		personas.add(p);
	}
	
	private GrafoPersona generarGrafoCompleto() {
		GrafoPersona grafoPersonas = new GrafoPersona(personas.size());
		for(Persona p:personas) {
			grafoPersonas.agregarPersona(p);
		}
		return grafoPersonas;
	}
	
	private GrafoPersona dividirEnGrupos() {
		GrafoPersona g = generarGrafoCompleto();
		g.mst();
		g.eliminarAristaMax();
		return g;
	}
	
	public void generarGrupos() {//una especie de BFS 
		GrafoPersona g = dividirEnGrupos();
		HashSet<Persona> visitados = new HashSet<>();
		boolean primeraIteracion=true;
		for(Pair<Persona, Persona> arista:g.aristas()) {
			if(primeraIteracion) {
				visitados.add(arista.fst);
				visitados.add(arista.snd);
				grupoA.add(arista.fst);
				grupoA.add(arista.snd);
				primeraIteracion=false;
			}
			if(visitados.contains(arista.fst) || visitados.contains(arista.snd)) {
				visitados.add(arista.fst);
				visitados.add(arista.snd);
				grupoA.add(arista.fst);
				grupoA.add(arista.snd);
			}
			else {
				grupoB.add(arista.fst);
				grupoB.add(arista.snd);
			}
		}
		if(visitados.size()<g.size()) {
			for(int i=0;i<g.size();i++) {
				Persona p = personas.get(i);
				if(!grupoA.contains(p)) {
					grupoB.add(p);
				}
			}
		}
	}
	
	public HashSet<Persona> getGrupoA(){
		if(grupoA.isEmpty() || grupoB.isEmpty()) throw new IllegalStateException("PRIMERO DEBE GENERAR LOS GRUPOS!");
		return grupoA;
	}
	
	public HashSet<Persona> getGrupoB(){
		if(grupoA.isEmpty() || grupoB.isEmpty()) throw new IllegalStateException("PRIMERO DEBE GENERAR LOS GRUPOS!");
		return grupoB;
	}
}
