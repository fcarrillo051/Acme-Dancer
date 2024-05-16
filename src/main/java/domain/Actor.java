
package domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import security.UserAccount;

@Entity
@Access(AccessType.PROPERTY)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Actor extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Actor() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	nombre;
	private String	apellidos;
	private String	correoElectronico;
	private String	numTelefono;
	private Integer	codigoPostal;


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
	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	@Pattern(regexp = "^([+-]\\d+\\s+)?(\\([0-9]+\\)\\s+)?([\\d\\w\\s-]+)$")
	public String getNumTelefono() {
		return this.numTelefono;
	}

	public void setNumTelefono(final String numTelefono) {
		this.numTelefono = numTelefono;
	}

	public Integer getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(final Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	// Relationships ----------------------------------------------------------

	private UserAccount userAccount;


	// FALTA AÑADIR LA RELACION PARA QUE LOS ACTORES SE PUEDAN SUSCRIBIR A OTROS ACTORES

	@NotNull
	@Valid
	@OneToOne(cascade = CascadeType.ALL, optional = false)
	public UserAccount getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(final UserAccount userAccount) {
		this.userAccount = userAccount;
	}
}
