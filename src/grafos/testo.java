package grafos;

import codigoNegocio.Persona;

public class testo {

	public static void main(String[] args) {
		MaxHashSet m= new MaxHashSet();
		m.add(new Arista(new Persona("a",1,1,1,1), new Persona("b",1,1,1,1), 5));
		m.add(new Arista(new Persona("c",1,1,1,1), new Persona("a",1,1,1,1), 4));
		m.add(new Arista(new Persona("d",1,1,1,1), new Persona("a",1,1,1,1), 3));
		m.remove(new Arista(new Persona("c",1,1,1,1), new Persona("a",1,1,1,1), 4));
		System.out.println(m);
	}

}
