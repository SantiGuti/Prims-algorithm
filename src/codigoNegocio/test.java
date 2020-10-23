package codigoNegocio;

public class test {

	public static void main(String[] args) {
		generadorDeArbol g = new generadorDeArbol(4);
		g.agregarPersona(new Persona("b",1,2,5,3));
		g.agregarPersona(new Persona("a",3,2,5,1));
		g.agregarPersona(new Persona("c",2,4,2,5));
		g.agregarPersona(new Persona("d",4,3,1,4));
		g.agregarArista("c", "d");//peso 5
		g.agregarArista("a", "b");//peso 4
		g.agregarArista("a", "d");//peso 9
		g.agregarArista("b", "d");//peso 9
		g.agregarArista("a", "c");//peso 10
		g.mst();
		g.eliminarAristaMax();
		System.out.println(g);
	}

}
