package grafos;

import codigoNegocio.Persona;

public class Arista implements Comparable {
	private final Persona[] vertices = new Persona[2];
	private int peso;
	
	
	public Arista(Persona i, Persona j, int peso) {
		if(i.equals(j))
			throw new IllegalArgumentException("NO SE PERMITEN LOOPS!");
		vertices[0]=i;
		vertices[1]=j;
		this.peso=peso;
	}
	
	public Arista(Persona i, Persona j) {
		if(i.equals(j))
			throw new IllegalArgumentException("NO SE PERMITEN LOOPS!");
		vertices[0]=i;
		vertices[1]=j;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this) { 
			 return true; 
	     } 
		if (o instanceof Arista) { 
            Arista a = (Arista) o;
            return ((a.vertices[0] == vertices[0] && a.vertices[1] == vertices[1]) || (a.vertices[1] == vertices[0] && a.vertices[0] == vertices[1]));
        } 
		return false;
	}
	
	public Persona getI() {
		return vertices[0];
	}
	public Persona getJ() {
		return vertices[1];
	}
	
	@Override
	public String toString() {
		return "["+vertices[0]+", "+vertices[1]+"]";
	}
	
	@Override
	public int hashCode() {
		return vertices[0].hashCode()+vertices[1].hashCode();
	}
	public int getPeso() {
		return peso;
	}

	@Override
	public int compareTo(Object o) {
		Arista arista = (Arista) o;
		return Integer.compare(this.peso, arista.peso);
	}
	
}
