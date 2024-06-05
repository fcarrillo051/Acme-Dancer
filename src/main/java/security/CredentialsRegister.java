/*
 * Credentials.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package security;

import javax.persistence.Column;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class CredentialsRegister {

	// Constructors -----------------------------------------------------------

	public CredentialsRegister() {
		super();
        this.tipoUsuario = "Alumno"; // Valor por defecto
	}


	// Attributes -------------------------------------------------------------

	private String	username;
	private String	password;
	private String	nombre;
	private String	apellidos;
	private String	correoElectronico;
	private String	numeroTelefono;
	private String	direccionPostal;
	private String nombreComercial;
    private String tipoUsuario; 
    
    public String getTipoUsuario() {
        return this.tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

	@Size(min = 5, max = 32)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Size(min = 5, max = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}


	@NotBlank
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	@NotBlank
	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(final String apellidos) {
		this.apellidos = apellidos;
	}

	@Email
	@NotBlank
	@Column(unique = true)
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Column(unique = true)
	@Pattern(regexp = "^([+-]\\d+\\s+)?(\\([0-9]+\\)\\s+)?([\\d\\w\\s-]+)$")
	public String getnumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setnumeroTelefono(final String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getdireccionPostal() {
		return this.direccionPostal;
	}

	public void setdireccionPostal(final String direccionPostal) {
		this.direccionPostal = direccionPostal;
	}

	public String getnombreComercial() {
		return this.nombreComercial;
	}

	public void setnombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}


}
