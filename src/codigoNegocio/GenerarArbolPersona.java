package codigoNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import grafos.Arista;


public class GenerarArbolPersona {
	private ArrayList<Persona> personas;
	private HashSet<Persona> grupoA;
	private HashSet<Persona> grupoB;
	private HashSet<Arista> pesos;
	
	public GenerarArbolPersona() {
		personas=new ArrayList<>();
		grupoA = new HashSet<>();
		grupoB = new HashSet<>();
	}
	
	public void agregarPersona(Persona p) {
		personas.add(p);
	}
		
	public void agregarPersonas(Persona[] p) {
		personas = (ArrayList<Persona>) Arrays.asList(p);
	}
	
	public void crearYAgregarPersona(String nombre, int deportes, int musica, int espectaculos, int ciencia) {
		Persona pers = new Persona(nombre, deportes, musica, espectaculos, ciencia);
		personas.add(pers);
	}
		
	private GrafoPersona generarGrafoCompleto() {
		GrafoPersona grafoPersonas = new GrafoPersona(personas.size());
		for(Persona p:personas) {
			grafoPersonas.agregarPersona(p);
		}
		return grafoPersonas;
	}
	
	public static Arista getAristaMax(HashSet<Arista> aristas) {
		return Collections.max(aristas);
	}
	
	private HashSet<Arista> dividirEnGrupos() {
		GrafoPersona g = generarGrafoCompleto();	
		HashSet<Arista> a=g.mst();
		return a;
	}
	
	public static double promedioSimilaridad(HashSet<Arista> pesos, HashSet<Persona> grupo) {
		double promedio = 0;
		for(Arista a:pesos) {
			if(grupo.contains(a.getI()) || grupo.contains(a.getJ())) {
				promedio += a.getPeso();
			}
		}
		return promedio/grupo.size();
	}
	
	public HashSet<Arista> getPesos(){
		return pesos;
	}
	
	public void generarGrupos() { 
		HashSet<Arista> g = dividirEnGrupos();
		Arista arista = getAristaMax(g);
		grupoA.add(arista.getI());
		grupoB.add(arista.getJ());
		g.remove(arista);
		pesos=g;
		for(Arista a:g) {
			if(grupoA.contains(a.getI()) || grupoA.contains(a.getJ())) {
				grupoA.add(a.getI());
				grupoA.add(a.getJ());
			}
			else {
				grupoB.add(a.getI());
				grupoB.add(a.getJ());
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
