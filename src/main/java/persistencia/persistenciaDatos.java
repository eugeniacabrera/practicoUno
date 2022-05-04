package persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.ejb.Singleton;
import jakarta.persistence.Cache;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnitUtil;
import jakarta.persistence.Query;
import jakarta.persistence.SynchronizationType;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import modelo.Persona;


@Singleton
public class persistenciaDatos implements persistenciaInterfazRemota, persistenciaInterfazLocal {
	
//	EntityManager em = (EntityManager) new EntityManagerFactory(); 
//	@PersistenceContext (unitName = "PracticoUno_PU")
//	EntityManager em;
//	
	List<Persona> lista = new ArrayList<>();
	
	public List<Persona> guardarPersona(Persona persona) {
		lista.add(persona);
		
		return lista;
	}
	
	public Persona buscarPersona(int idPersona) {
		for (Persona persona : lista) {
	        if (persona.getIdpersona() == idPersona) {
	            return persona;
	        }
	    }
	    return null;
	}	
	
	public void editarPersona(Persona persona) {
		for (Persona p : lista) {
	        if (p.getIdpersona() == persona.getIdpersona()) {
	            p.setNombre(persona.getNombre());
	            p.setTelefono(persona.getTelefono());
	            p.setFechaNac(persona.getFechaNac());
	        }
	    }
	}
	
	public void eliminarPersona(int idPersona) {
		for (Persona p : lista) {
	        if (p.getIdpersona() == idPersona) {
	            lista.remove(p);
	            return;
	        }
	    }
	}
	
	public List<Persona> listarPersonas(){
		return lista;
	}

	
	
	
}
