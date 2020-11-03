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
	
	public int getDeportes() {
		return interesDeportes;
	}
	
	public int getMusica() {
		return interesMusica;
	}
	
	public int getEspectaculo() {
		return interesEspectaculo;
	}
	
	public int getCiencia() {
		return interesCiencia;
	}
	@Override
	public String toString() {
		return "Nombre: " + nombre + ". Deportes: " + interesDeportes + ". Musica: " + interesMusica + ". Espectaculo: " + interesEspectaculo + ". Ciencia: " + interesCiencia;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (obj.getClass() == this.getClass()) {
			Persona object = (Persona) obj;
			return object.getNombre().equals(this.getNombre()) 
				&& object.getDeportes() == this.getDeportes() 
				&& object.getMusica() == this.getMusica() 
				&& object.getEspectaculo() == this.getEspectaculo() 
				&& object.getCiencia() == this.getCiencia();
		}
		return false;
	}
}
