package codigoNegocio;


public class test {

	public static void main(String[] args) {
		GenerarArbolPersona g = new GenerarArbolPersona();
		Persona p0=new Persona("boca",2,3,2,3);
		Persona p1=new Persona("river",2,3,2,3);
		g.agregarPersona(p0);
		g.agregarPersona(p1);
		g.generarGrupos();
		System.out.println("g"+g.getGrupoA());
		System.out.println(g.getGrupoB());
//		System.out.println(g.promedioSimilaridad(g.getPesos(), g.getGrupoB()));
	}

}
