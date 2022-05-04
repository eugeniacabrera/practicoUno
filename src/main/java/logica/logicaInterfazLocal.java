package logica;

import java.util.List;

import jakarta.ejb.Local;
import modelo.Persona;

@Local
public interface logicaInterfazLocal {
	
	public List<Persona> guardarPersona(Persona persona);
	public Persona buscarPersona(int idPersona);
	public void editarPersona(Persona persona);
	public void eliminarPersona(int idPersona);
	public List<Persona> listarPersonas();
	
	
}
