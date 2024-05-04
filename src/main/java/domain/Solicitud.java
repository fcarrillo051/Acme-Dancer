
package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Solicitud extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Solicitud() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private Date momentoSolicitud;


	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getMomentoSolicitud() {
		return this.momentoSolicitud;
	}

	public void setMomentoSolicitud(final Date momentoSolicitud) {
		this.momentoSolicitud = momentoSolicitud;
	}


	// Relationships ----------------------------------------------------------

	private Alumno	dueño;
	private Curso	curso;


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Alumno getDueño() {
		return this.dueño;
	}

	public void setDueño(final Alumno dueño) {
		this.dueño = dueño;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(final Curso curso) {
		this.curso = curso;
	}

}
