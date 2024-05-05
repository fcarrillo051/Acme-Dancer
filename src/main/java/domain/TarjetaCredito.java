
package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

@Entity
@Access(AccessType.PROPERTY)
public class TarjetaCredito extends DomainEntity {

	// Constructors -----------------------------------------------------------

	public TarjetaCredito() {
		super();
	}


	// Attributes -------------------------------------------------------------

	private String	nombreTitular;
	private String	marca;
	private String	numero;
	private int		mesCad;
	private int		anioCad;
	private Integer	cvv;


	@NotBlank
	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(final String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	@NotBlank
	public String getMarca() {
		return this.marca;
	}

	public void setMarca(final String marca) {
		this.marca = marca;
	}

	@CreditCardNumber
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(final String numero) {
		this.numero = numero;
	}

	@Range(min = 1, max = 12)
	public int getMesCad() {
		return this.mesCad;
	}

	public void setMesCad(final int mesCad) {
		this.mesCad = mesCad;
	}

	@Range(min = 2024, max = 2100)
	public int getAnioCad() {
		return this.anioCad;
	}

	public void setAnioCad(final int anioCad) {
		this.anioCad = anioCad;
	}

	@Range(min = 100, max = 999)
	public Integer getCvv() {
		return this.cvv;
	}

	public void setCvv(final int cvv) {
		this.cvv = cvv;
	}


	// Relationships ----------------------------------------------------------

	private Alumno alumno;


	@NotNull
	@Valid
	@OneToOne(optional = false)
	public Alumno getAlumno() {
		return this.alumno;
	}

	public void setAlumno(final Alumno alumno) {
		this.alumno = alumno;
	}

}
