
package services;

import java.util.Collection;
import java.util.Date;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Academia;
import domain.Alumno;
import domain.Curso;
import domain.EstadoSolicitud;
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

	@Autowired
	private AcademiaService		academiaService;


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

	public Solicitud findByAlumnoAndCurso(Alumno alumno, Curso curso) {
		Assert.assertNotNull(alumno);
		Assert.assertNotNull(curso);

		Solicitud result;

		result = this.solicitudRepository.findByAlumnoIdAndCursoId(alumno.getId(), curso.getId());

		return result;
	}

	public Solicitud findByAlumnoAndCurso(Curso curso) {
		return this.findByAlumnoAndCurso(this.alumnoService.findByPrincipal(), curso);
	}

	public Solicitud createSolicitud(Curso curso) {
		Assert.assertNotNull(curso);

		Solicitud result;
		Date moment;
		Alumno alumno;

		moment = new Date(System.currentTimeMillis() - 1);
		alumno = this.alumnoService.findByPrincipal();

		result = new Solicitud();
		result.setCurso(curso);
		result.setMomentoSolicitud(moment);
		result.setEstadoSolicitud(EstadoSolicitud.Pendiente);
		result.setDueño(alumno);

		return result;
	}

	public Collection<Solicitud> findByAlumno(Alumno alumno) {
		Assert.assertNotNull(alumno);

		Collection<Solicitud> result;

		System.out.println("ID DE ALUMNO " + alumno.getId());
		result = this.solicitudRepository.findByAlumnoId(alumno.getId());

		return result;
	}

	public Collection<Solicitud> findByAlumno() {
		return this.findByAlumno(this.alumnoService.findByPrincipal());
	}

	public Collection<Solicitud> findByAcademia(Academia alumno) {
		Assert.assertNotNull(alumno);

		Collection<Solicitud> result;

		result = this.solicitudRepository.findByAcademyId(alumno.getId());

		return result;
	}

	public Collection<Solicitud> findByAcademia() {
		return this.findByAcademia(this.academiaService.findByPrincipal());
	}
}
