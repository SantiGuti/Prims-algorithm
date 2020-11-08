package codigoNegocio;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Persona {
	private String nombre;
	private int interesDeportes;
	private int interesMusica;
	private int interesEspectaculo;
	private int interesCiencia;
	
	public Persona(String nombre, int interesDeporte, int interesMusica, int interesEspectaculo, int interesCiencia) {
		if(interesDeporte<1 || interesDeporte>5) throw new IllegalArgumentException("EL NIVEL DE INTERES ES DE 1 A 5");
		if(interesMusica<1 || interesMusica>5) throw new IllegalArgumentException("EL NIVEL DE INTERES ES DE 1 A 5");
		if(interesEspectaculo<1 || interesEspectaculo>5) throw new IllegalArgumentException("EL NIVEL DE INTERES ES DE 1 A 5");
		if(interesCiencia<1 || interesCiencia>5) throw new IllegalArgumentException("EL NIVEL DE INTERES ES DE 1 A 5");
		if (!isNameOK(nombre)) throw new IllegalArgumentException("Ingresar nombre/El nombre no puede contener numeros");
		
		this.nombre = nombre;
		this.interesDeportes = interesDeporte;
		this.interesMusica = interesMusica;
		this.interesEspectaculo = interesEspectaculo;
		this.interesCiencia = interesCiencia;
	}
	
	public int indiceSimilaridad(Persona j) {
		return Math.abs(this.interesDeportes-j.interesDeportes)+Math.abs(this.interesCiencia-j.interesCiencia)+Math.abs(this.interesMusica-j.interesMusica)+Math.abs(this.interesEspectaculo-j.interesEspectaculo);
	}
	
	private boolean isNameOK(String name) {
		if (name.isEmpty()) {
			return false;
		}
	    Pattern p = Pattern.compile( "[0-9]" );
	    Matcher m = p.matcher(name);
	    if (m.find()) {
	    	return false;
	    }
	    return true;
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
		return getNombre();
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
