package modelo;

import java.util.Date;

public class Persona {
	
	
    private int idpersona;
    private String nombre;
    private int telefono;
    private Date fechaNac;

    public Persona(){
    }

	public Persona(int id, String nombre, int telefono, Date fechaNac) {
		//super();
		this.idpersona = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
	}

	public int getIdpersona() {
		return idpersona;
	}

	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
    
    
}
