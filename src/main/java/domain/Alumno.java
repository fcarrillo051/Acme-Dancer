
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor {

	// Constructors -----------------------------------------------------------

	public Alumno() {
		super();
		this.solicitudes = new HashSet<Solicitud>();
	}

	// Attributes -------------------------------------------------------------


	// Relationships ----------------------------------------------------------

	private Collection<Solicitud> solicitudes;


	@NotNull
	@OneToMany(mappedBy = "dueño")
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
