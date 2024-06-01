
package domain;

import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Alumno extends Actor {

	// Constructors -----------------------------------------------------------

	public Alumno() {
		super();
		this.solicitudes = new HashSet<Solicitud>();
		this.registros = new HashSet<Registro>();
	}

	// Attributes -------------------------------------------------------------


	// Relationships ----------------------------------------------------------

	private Collection<Solicitud>	solicitudes;
	private TarjetaCredito			tarjetaCredito;
	private Collection<Registro>	registros;


	@NotNull
	@OneToMany(mappedBy = "dueño")
	public Collection<Solicitud> getSolicitudes() {
		return this.solicitudes;
	}

	public void setSolicitudes(final Collection<Solicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}

	@OneToOne(mappedBy = "alumno")
	public TarjetaCredito getTarjetaCredito() {
		return this.tarjetaCredito;
	}

	public void setTarjetaCredito(final TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	@NotNull
	@OneToMany(mappedBy = "dueño")
	public Collection<Registro> getRegistros() {
		return this.registros;
	}

	public void setRegistros(Collection<Registro> registros) {
		this.registros = registros;
	}

	public void addRegistro(Registro registro) {
		this.registros.add(registro);
		registro.setDueño(this);
	}

	public void removeRegistro(Registro registro) {
		this.registros.remove(registro);
		registro.setDueño(null);
	}

}
