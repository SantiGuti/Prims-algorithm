package codigoNegocio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import grafos.Arista;
import grafos.MaxHashSet;


public class GenerarArbolPersona {
	private ArrayList<Persona> personas;
	private HashSet<Persona> grupoA;
	private HashSet<Persona> grupoB;
	private MaxHashSet pesos;
	
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
	
	public boolean crearYAgregarPersona(String nombre, int deportes, int musica, int espectaculos, int ciencia) {
		Persona pers = new Persona(nombre, deportes, musica, espectaculos, ciencia);
		if(!existePersona(pers)) {
			personas.add(pers);
			return true;
		}
		return false;
	}
		
	private GrafoPersona generarGrafoCompleto() {
		GrafoPersona grafoPersonas = new GrafoPersona(personas.size());
		for(Persona p:personas) {
			grafoPersonas.agregarPersona(p);
		}
		return grafoPersonas;
	}
	
	private MaxHashSet dividirEnGrupos() {
		GrafoPersona g = generarGrafoCompleto();	
		MaxHashSet a=g.mst();
		return a;
	}
	
	public double promedioSimilaridad(HashSet<Persona> grupo) {
		double promedio = 0;
		for(Arista a:pesos) {
			if(grupo.contains(a.getI()) || grupo.contains(a.getJ())) {
				promedio += a.getPeso();
			}
		}
		return promedio/grupo.size();
	}
	
	public boolean generarGrupos() { 
		if(personas.isEmpty() || personas.size()<2)
			return false;
		MaxHashSet g = dividirEnGrupos();
		Arista arista = g.getMax();
		grupoA.add(arista.getI());
		grupoB.add(arista.getJ());
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
		return true;
	}
	
	public static Double porcentajeDeportes(HashSet<Persona> grupo) {
		Double deportes = new Double(0);
		for(Persona p:grupo) {
			deportes+=p.getDeportes();
		}
		return deportes/grupo.size();
	}
	public static Double porcentajeCiencia(HashSet<Persona> grupo) {
		Double ciencia = new Double(0);
		for(Persona p:grupo) {
			ciencia+=p.getCiencia();
		}
		return ciencia/grupo.size();
	}
	public static Double porcentajeEspectaculos(HashSet<Persona> grupo) {
		Double espectaculos = new Double(0);
		for(Persona p:grupo) {
			espectaculos+=p.getEspectaculo();
		}
		return espectaculos/grupo.size();
	}
	public static Double porcentajeMusica(HashSet<Persona> grupo) {
		Double musica = new Double(0);
		for(Persona p:grupo) {
			musica+=p.getMusica();
		}
		return musica/grupo.size();
	}
	public HashSet<Persona> getGrupoA(){
		return grupoA;
	}
	
	public HashSet<Persona> getGrupoB(){
		return grupoB;
	}
	
	public boolean IsEmpty() {
		return (personas.size()<2);
	}
	
	private boolean existePersona(Persona p) {
		return personas.contains(p);
	}
}
