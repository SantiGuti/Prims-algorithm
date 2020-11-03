package codigoNegocio;


public class test {

	public static void main(String[] args) {
		GenerarArbolPersona g = new GenerarArbolPersona();
		Persona p0=new Persona("boca",2,3,2,3);
		Persona p1=new Persona("rover",2,2,2,2);
		Persona p2=new Persona("asd",5,5,5,5);
		Persona p3=new Persona("bwef",5,5,5,5);
		Persona p4=new Persona("indep",2,3,4,1);
		g.agregarPersona(p0);
		g.agregarPersona(p1);
		g.agregarPersona(p2);
		g.agregarPersona(p3);
		g.agregarPersona(p4);
		g.generarGrupos();
		System.out.println(g.getGrupoA());
		System.out.println(g.getGrupoB());
		System.out.println(g.promedioSimilaridad(g.getPesos(), g.getGrupoB()));
	}

}
