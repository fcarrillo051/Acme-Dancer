
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
public class Registro extends DomainEntity {

	public Registro() {
		super();
	}


	private Date momentoRegistro;


	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getMomentoRegistro() {
		return this.momentoRegistro;
	}

	public void setMomentoRegistro(final Date moment) {
		this.momentoRegistro = moment;
	}


	private Solicitud	solicitud;
	private Alumno		dueño;


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Solicitud getSolicitud() {
		return this.solicitud;
	}

	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Alumno getDueño() {
		return this.dueño;
	}

	public void setDueño(Alumno dueño) {
		this.dueño = dueño;
	}

}
