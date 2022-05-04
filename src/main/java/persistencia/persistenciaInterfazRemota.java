package persistencia;

import java.util.List;

import jakarta.ejb.Remote;
import modelo.Persona;

@Remote
public interface persistenciaInterfazRemota {
	public List<Persona> guardarPersona(Persona persona);
	public Persona buscarPersona(int idPersona);
	public void editarPersona(Persona persona);
	public void eliminarPersona(int idPersona);
	public List<Persona> listarPersonas();
}
