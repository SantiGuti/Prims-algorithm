package codigoNegocio;

public class test {

	public static void main(String[] args) {
		GenerarArbolPersona g = new GenerarArbolPersona();
		g.agregarPersona(new Persona("b",1,2,5,3));
		g.agregarPersona(new Persona("a",1,2,5,3));
		g.agregarPersona(new Persona("c",1,2,5,3));
		g.agregarPersona(new Persona("d",5,5,1,1));
		g.agregarPersona(new Persona("e",1,2,5,3));
		g.generarGrupos();
		System.out.println(g.getGrupoA());
		System.out.println(g.getGrupoB());
	}

}
