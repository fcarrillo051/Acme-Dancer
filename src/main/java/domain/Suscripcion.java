
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Suscripcion extends DomainEntity {

	// Constructors -----------------------------------------------------------
	public Suscripcion() {
		super();
	}


	// Relationships ----------------------------------------------------------
	private Actor	suscriptor;
	private Actor	creador;


	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Actor getSuscriptor() {
		return this.suscriptor;
	}

	public void setSuscriptor(final Actor suscriptor) {
		this.suscriptor = suscriptor;
	}

	@NotNull
	@Valid
	@ManyToOne(optional = false)
	public Actor getCreador() {
		return this.creador;
	}

	public void setCreador(final Actor creador) {
		this.creador = creador;
	}
}
