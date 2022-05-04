package logica;

import java.util.List;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import modelo.Persona;
import persistencia.persistenciaDatos;
import persistencia.persistenciaInterfazLocal;
import persistencia.persistenciaInterfazRemota;

@Stateless
public class logicaBean implements logicaInterfazLocal, logicaInterfazRemota{

//	@EJB
//	private persistenciaInterfazLocal persistenciaInterfazLocal;
//	@EJB
//	private persistenciaInterfazRemota persistenciaInterfazRemota;
	
	persistenciaInterfazLocal persistenciaInterfazLocal = new persistenciaDatos();
	persistenciaInterfazRemota persistenciaInterfazRemota = new persistenciaDatos();

	

	
	// metodos interfaz local
	public List<Persona> guardarPersona(Persona persona) {
		List<Persona> listaPersona = persistenciaInterfazLocal.guardarPersona(persona);
		return listaPersona;
	}
	
	public Persona buscarPersona(int idPersona) {
		Persona p= persistenciaInterfazLocal.buscarPersona(idPersona);
		return p;
	}
	
	public void editarPersona(Persona persona) {
		persistenciaInterfazLocal.editarPersona(persona);
	}
	
	public void eliminarPersona(int idpersona) {
		persistenciaInterfazLocal.eliminarPersona(idpersona);
	}
	
	public List<Persona> listarPersonas(){
		List<Persona> personaLista = persistenciaInterfazLocal.listarPersonas();
		return personaLista;
	}
	
	// metodos interfaz remota
		public List<Persona> guardarPersonaR(Persona persona) {
			List<Persona> listaPersonas = persistenciaInterfazRemota.guardarPersona(persona);
			return listaPersonas;
		}
		
		public Persona buscarPersonaR(int idPersona) {
			Persona p= persistenciaInterfazRemota.buscarPersona(idPersona);
			return p;
		}
		
		public void editarPersonaR(Persona persona) {
			persistenciaInterfazRemota.editarPersona(persona);
		}
		
		public void eliminarPersonaR(int idPersona) {
			persistenciaInterfazRemota.eliminarPersona(idPersona);
		}
		
		public List<Persona> listarPersonasR(){
			List<Persona> personaLista = persistenciaInterfazRemota.listarPersonas();
			return personaLista;
		}
	
	
}
