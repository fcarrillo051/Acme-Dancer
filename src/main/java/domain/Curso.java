
package domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
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
	//private Date			horaImpartido;
	private String			horaImpartido;


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
		// Verificar si fechaFinal es mayor que fechaInicio
		if (fechaFinal != null && this.fechaInicio != null && fechaFinal.before(this.fechaInicio))
			throw new IllegalArgumentException("La fecha final debe ser posterior a la fecha de inicio");
		this.fechaFinal = fechaFinal;
	}

	@NotNull
	public DiaImpartido getDiaImpartido() {
		return this.diaImpartido;
	}

	public void setDiaImpartido(final DiaImpartido diaImpartido) {
		this.diaImpartido = diaImpartido;
	}

	@NotNull
	public String getHoraImpartido() {
		return this.horaImpartido;
	}

	public void setHoraImpartido(final String horaImpartido) {
		this.horaImpartido = horaImpartido;
	}
	/*
	 * @Temporal(TemporalType.TIMESTAMP)
	 *
	 * @DateTimeFormat(pattern = "HH:mm")
	 * public Date getHoraImpartido() {
	 * return this.horaImpartido;
	 * }
	 *
	 * public void setHoraImpartido(final Date horaImpartido) {
	 * this.horaImpartido = horaImpartido;
	 * }
	 */


	// Relationships ----------------------------------------------------------

	private Collection<Solicitud>	solicitudes;
	private Estilo					estilo;
	private Academia				academia;


	@NotNull
	@OneToMany(mappedBy = "curso")
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Estilo getEstilo() {
		return this.estilo;
	}

	public void setEstilo(final Estilo estilo) {
		this.estilo = estilo;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Academia getAcademia() {
		return this.academia;
	}

	public void setAcademia(final Academia academia) {
		this.academia = academia;
	}

}
