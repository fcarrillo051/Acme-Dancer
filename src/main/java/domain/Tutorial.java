
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Tutorial extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Tutorial() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	titulo;
	private String	descripcion;
	private String	video;
	private Integer	visitas;


	@NotBlank
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(final String titulo) {
		this.titulo = titulo;
	}

	@NotBlank
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(final String descripcion) {
		this.descripcion = descripcion;
	}

	@URL
	public String getVideo() {
		return this.video;
	}

	public void setVideo(final String video) {
		this.video = video;
	}

	public Integer getVisitas() {
		return this.visitas;
	}

	public void setVisitas(final Integer visitas) {
		this.visitas = visitas;
	}


	// Relationships ----------------------------------------------------------

	private Academia academia;


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
