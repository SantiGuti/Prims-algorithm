import java.util.ArrayList;

public class Persona {
	private String nombre;
	private int interesDeportes;
	private int interesMusica;
	private int interesEspectaculo;
	private int interesCiencia;
	
	public Persona(String nombre, int interesDeporte, int interesMusica, int interesEspectaculo, int interesCiencia) {
		this.nombre = nombre;
		this.interesDeportes = interesDeporte;
		this.interesMusica = interesMusica;
		this.interesEspectaculo = interesEspectaculo;
		this.interesCiencia = interesCiencia;
	}
	
	public int indiceSimilaridad(Persona j) {
		return 0;
	}
	
	public String getNombre() {
		return nombre;
	}
}
