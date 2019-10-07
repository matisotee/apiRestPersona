package utn.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="api_persona")
public class Persona extends BaseEntity{
	
	@Column(name = "persona_nombre")
	private String nombre;

	@Column(name = "persona_apellido")
	private String apellido;

	@Column(name = "persona_edad")
	private int edad;
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	
	
	
	
}
