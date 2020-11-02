package codigoNegocio;


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
		return Math.abs(this.interesDeportes-j.interesDeportes)+Math.abs(this.interesCiencia-j.interesCiencia)+Math.abs(this.interesMusica-j.interesMusica)+Math.abs(this.interesEspectaculo-j.interesEspectaculo);
	}
	
	public String getNombre() {
		return nombre;
	}
	@Override
	public String toString() {
		return nombre;
	}
}
