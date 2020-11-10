package codigoNegocio;


public class test {

	public static void main(String[] args) {
		GenerarArbolPersona g = new GenerarArbolPersona();
		Persona p0=new Persona("boca",1,1,1,1);
		Persona p1=new Persona("river",1,1,1,1);
		g.agregarPersona(p0);
		g.agregarPersona(p1);
		g.generarGrupos();
		System.out.println("grupo A"+g.getGrupoA());
		System.out.println("grupo B"+g.getGrupoB());
		g.agregarPersona(new Persona("lanuz",1,1,1,1));
		g.agregarPersona(new Persona("g",5,5,5,5));
		g.generarGrupos();
		System.out.println("grupo A"+g.getGrupoA());
		System.out.println("grupo B"+g.getGrupoB());
	}

}
