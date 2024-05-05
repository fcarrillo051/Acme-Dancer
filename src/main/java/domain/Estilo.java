
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

@Entity
@Access(AccessType.PROPERTY)
public class Estilo extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public Estilo() {
		super();
		this.cursos = new HashSet<Curso>();
	}


	// Attributes -------------------------------------------------------------

	private String				titulo;
	private String				descripcion;
	private Collection<String>	videos;
	private Collection<String>	imagenes;


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

	@ElementCollection
	@URL
	public Collection<String> getVideos() {
		return this.videos;
	}

	public void setVideos(final Collection<String> videos) {
		this.videos = videos;
	}

	@ElementCollection
	@URL
	public Collection<String> getImagenes() {
		return this.imagenes;
	}

	public void setImagenes(final Collection<String> imagenes) {
		this.imagenes = imagenes;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Curso> cursos;


	@NotNull
	@OneToMany(mappedBy = "estilo")
	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}

}
