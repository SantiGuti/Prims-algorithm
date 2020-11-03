package codigoNegocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersonasJSON {
	
	private ArrayList<Persona> personas;
	
	public PersonasJSON() {
		personas = new ArrayList<Persona>();
	}
	
	public void addPers(Persona p) {
		personas.add(p);
	}
	
	public void removePers(Persona p) {
		personas.remove(p);
	}
	
	public void printPers() {
		for (int i = 0; i < personas.size(); i++) {
			System.out.println(personas.get(i));
		}
	}
	
	public String generarJSON() {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(this);
		
		return json;
	}
	
	public void guardarJSON(String json, String archivoDestino) {
		try
		{
			FileWriter writer = new FileWriter(archivoDestino);
			writer.write(json);
			writer.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static PersonasJSON leerJSON(String archivo) {
		Gson gson = new Gson();
		PersonasJSON ret = null;
		
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(archivo));
			ret = gson.fromJson(br, PersonasJSON.class);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		// Creo personas
		Persona carlos = new Persona("Carlos", 5, 1, 3, 2);
		Persona julian = new Persona("Julian", 1, 3, 1, 2);
		Persona maga = new Persona("Magali", 1, 1, 1, 5);
		Persona rafi = new Persona("Rafi", 5, 1, 1, 1);
		
		// Creo una instancia de la clase que se ocupa de guardar personas en JSON
		PersonasJSON guardarPersonas = new PersonasJSON();
		
		// Guardo las personas en la instancia de PersonasJSON
		guardarPersonas.addPers(carlos);
		guardarPersonas.addPers(julian);
		guardarPersonas.addPers(maga);
		guardarPersonas.addPers(rafi);
		
		// Creo el JSON y guardo lo que tengo en el array en el JSON
		String json = guardarPersonas.generarJSON();
		guardarPersonas.guardarJSON(json, "Personas.JSON");
		
		// Luego creo una nueva instancia de la clase en intento leer el JSON recien creado
		PersonasJSON cargarPersonas = new PersonasJSON();
		cargarPersonas = PersonasJSON.leerJSON("Personas.JSON");
		cargarPersonas.printPers();
	}
}
