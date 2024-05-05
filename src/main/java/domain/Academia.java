
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Access(AccessType.PROPERTY)
public class Academia extends Actor {

	// Constructors -----------------------------------------------------------

	public Academia() {
		super();
		this.cursos = new HashSet<Curso>();
		this.tutoriales = new HashSet<Tutorial>();
	}


	// Attributes -------------------------------------------------------------

	private String nombreComercial;


	@NotBlank
	public String getNombreComercial() {
		return this.nombreComercial;
	}

	public void setNombreComercial(final String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}


	// Relationships ----------------------------------------------------------

	private Collection<Curso>		cursos;
	private Collection<Tutorial>	tutoriales;


	@NotNull
	@OneToMany(mappedBy = "academia")
	public Collection<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}

	@NotNull
	@OneToMany(mappedBy = "academia")
	public Collection<Tutorial> getTutoriales() {
		return this.tutoriales;
	}

	public void setTutoriales(Collection<Tutorial> tutoriales) {
		this.tutoriales = tutoriales;
	}

}
