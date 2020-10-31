package codigoNegocio;
import java.util.HashSet;

public class test {

	public static void main(String[] args) {
		GenerarArbolPersona g = new GenerarArbolPersona();
		Persona p0=new Persona("0",2,3,2,3);
		Persona p1=new Persona("1",2,2,2,2);
		Persona p2=new Persona("2",5,5,5,5);
		Persona p3=new Persona("3",5,5,5,5);
		g.agregarPersona(p0);
		g.agregarPersona(p1);
		g.agregarPersona(p2);
		g.agregarPersona(p3);
		g.generarGrupos();
		System.out.println(g.getGrupoA());
		System.out.println(g.getGrupoB());
		System.out.println(g.promedioSimilaridad(g.getPesos(), g.getGrupoB()));
	}

}
