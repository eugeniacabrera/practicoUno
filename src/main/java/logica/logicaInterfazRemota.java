package logica;

import java.util.List;

import jakarta.ejb.Remote;
import modelo.Persona;

@Remote
public interface logicaInterfazRemota {
	
	public List<Persona> guardarPersonaR(Persona persona);
	public Persona buscarPersonaR(int idPersona);
	public void editarPersonaR(Persona persona);
	public void eliminarPersonaR(int idPersona);
	public List<Persona> listarPersonasR();
	
}
