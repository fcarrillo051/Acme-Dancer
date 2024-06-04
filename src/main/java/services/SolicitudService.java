
package services;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;
import domain.Solicitud;
import repositories.SolicitudRepository;

@Service
@Transactional
public class SolicitudService {

	// Managed repository -------------------------------
	@Autowired
	private SolicitudRepository	solicitudRepository;

	@Autowired
	private AlumnoService		alumnoService;


	// Simple CRUD methods ------------------------------
	public Solicitud create() {
		return new Solicitud();
	}

	public Collection<Solicitud> findAll() {
		return this.solicitudRepository.findAll();
	}

	public Solicitud findOne(int solicitudId) {
		return this.solicitudRepository.findOne(solicitudId);
	}

	public Solicitud save(Solicitud solicitud) {
		return this.solicitudRepository.save(solicitud);
	}

	public void delete(Solicitud solicitud) {
		this.solicitudRepository.delete(solicitud);
	}

	public Collection<Solicitud> findAllActive() {
		Collection<Solicitud> result;
		Date currentMoment;

		currentMoment = new Date();
		result = this.solicitudRepository.findAllActive(currentMoment);
		Assert.assertNotNull(result);
		return result;
	}

	public Collection<Solicitud> findRegistered() {
		Collection<Solicitud> result;
		Alumno alumno;

		alumno = this.alumnoService.findByPrincipal();
		result = this.solicitudRepository.findByAlumnoId(alumno.getId());
		Assert.assertNotNull(result);
		return result;
	}

	// Other business methods ---------------------------
}
