
package domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Curso extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Curso() {
		super();

		this.solicitudes = new HashSet<Solicitud>();
	}


	// Attributes -------------------------------------------------------------

	private String			titulo;
	private Nivel			nivel;
	private Date			fechaInicio;
	private Date			fechaFinal;
	private DiaImpartido	diaImpartido;
	private Date			horaImpartido;


	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void setNivel(final Nivel nivel) {
		this.nivel = nivel;
	}

	//Añadir restriccion fechaFin > fechaInicio

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(final Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
	public Date getFechaFinal() {
		return this.fechaFinal;
	}

	public void setFechaFinal(final Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	//Añadir etiquetas
	public DiaImpartido getDiaImpartido() {
		return this.diaImpartido;
	}

	public void setDiaImpartido(final DiaImpartido diaImpartido) {
		this.diaImpartido = diaImpartido;
	}
	//Añadir etiquetas
	public Date getHoraImpartido() {
		return this.horaImpartido;
	}

	public void setHoraImpartido(final Date horaImpartido) {
		this.horaImpartido = horaImpartido;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Solicitud> solicitudes;


	@NotNull
	@OneToMany(mappedBy = "curso")
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
