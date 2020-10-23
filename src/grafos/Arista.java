package grafos;

public class Arista implements Comparable {
	private final int[] vertices = new int[2];
	private int peso;
	
	public Arista(int i, int j, int peso) {
		if(i==j)
			throw new IllegalArgumentException("NO SE PERMITEN LOOPS!");
		vertices[0]=i;
		vertices[1]=j;
		this.peso=peso;
	}
	
	public Arista(int i, int j) {
		if(i==j)
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
	
	public int getI() {
		return vertices[0];
	}
	public int getJ() {
		return vertices[1];
	}
	
	@Override
	public String toString() {
		return "["+vertices[0]+", "+vertices[1]+"]";
	}
	
	@Override
	public int hashCode() {
		return vertices[0]*vertices[0]+vertices[1]*vertices[1];
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
