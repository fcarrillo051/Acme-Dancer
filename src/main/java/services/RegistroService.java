
package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Alumno;
import domain.Registro;
import domain.Solicitud;
import repositories.RegistroRepository;

@Service
@Transactional
public class RegistroService {

	private RegistroRepository	registroRepository;

	private AlumnoService		alumnoService;


	public RegistroService() {
		super();
	}

	public Registro createRegistration(Solicitud solicitud) {
		Assert.notNull(solicitud);

		Registro result;
		Date moment;
		Alumno alumno;

		moment = new Date(System.currentTimeMillis() - 1);
		alumno = this.alumnoService.findByPrincipal();

		result = new Registro();
		result.setSolicitud(solicitud);
		result.setMomentoRegistro(moment);

		result.setDueño(alumno);

		return result;
	}

	public Registro save(Registro registration) {
		Assert.notNull(registration);

		Registro result;

		result = this.registroRepository.save(registration);

		return result;
	}

	public void delete(Registro registro) {
		Assert.notNull(registro);
		Assert.isTrue(registro.getId() != 0);

		this.registroRepository.delete(registro);
	}

	// Business methods -------------------------------------------------------

	public Collection<Registro> findByPrincipal() {
		Collection<Registro> result;
		Alumno alumno;

		alumno = this.alumnoService.findByPrincipal();
		result = alumno.getRegistros();

		return result;
	}

	public boolean existsRegistroForSolicitud(Solicitud solicitud) {
		boolean result;
		Collection<Registro> registros;

		registros = this.registroRepository.findBySolicitudId(solicitud.getId());
		result = !registros.isEmpty();

		return result;
	}

	public Registro findByAlumnoAndSolicitud(Alumno alumno, Solicitud solicitud) {
		Assert.notNull(alumno);
		Assert.notNull(solicitud);

		Registro result;

		result = this.registroRepository.findByAlumnoIdAndSolicitudId(alumno.getId(), solicitud.getId());

		return result;
	}

}
