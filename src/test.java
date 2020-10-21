
public class test {

	public static void main(String[] args) {
		generadorDeArbol g = new generadorDeArbol(4);
		g.agregarPersona(new Persona("b",1,1,1,1));
		g.agregarPersona(new Persona("a",1,1,1,1));
		g.agregarPersona(new Persona("c",1,1,1,1));
		g.agregarPersona(new Persona("d",1,1,1,1));
		g.agregarArista("c", "d");
		g.agregarArista("a", "b");
		g.agregarArista("a", "c");
		System.out.println(g.toString());
	}

}
