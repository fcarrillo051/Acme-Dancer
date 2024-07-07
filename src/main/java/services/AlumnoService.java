
package services;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Alumno;
import domain.Registro;
import domain.Solicitud;
import domain.TarjetaCredito;
import repositories.AlumnoRepository;
import repositories.TarjetaCreditoRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class AlumnoService {

	// Managed repository -------------------------------
	@Autowired
	private AlumnoRepository			alumnoRepository;

	@Autowired
	private TarjetaCreditoRepository	tarjetaRepository;

	@Autowired
	private SolicitudService			solicitudService;

	@Autowired
	private RegistroService				registroService;


	// Simple CRUD methods ------------------------------
	public Alumno create() {
		return new Alumno();
	}

	public Collection<Alumno> findAll() {
		return this.alumnoRepository.findAll();
	}

	public Alumno findOne(int alumnoId) {
		return this.alumnoRepository.findOne(alumnoId);
	}

	public Alumno save(Alumno alumno) {
		return this.alumnoRepository.save(alumno);
	}

	public void delete(Alumno alumno) {
		this.alumnoRepository.delete(alumno);
	}

	public Alumno findByPrincipal() {
		Alumno result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = this.findByUserAccount(userAccount);
		Assert.notNull(result);

		return result;
	}

	public Alumno findByUserAccount(UserAccount userAccount) {
		Assert.notNull(userAccount);
		Alumno result;
		result = this.alumnoRepository.findByUserAccountId(userAccount.getId());
		return result;
	}

	public void registerPrincipal(int solcitudId) {
		Assert.isTrue(solcitudId != 0);

		Alumno alumno;
		Solicitud solicitud;
		Registro registro;
		Date currentMoment;

		alumno = this.findByPrincipal();
		Assert.notNull(alumno);
		solicitud = this.solicitudService.findOne(solcitudId);
		Assert.notNull(solicitud);
		currentMoment = new Date();
		Assert.isTrue(solicitud.getMomentoSolicitud().after(currentMoment));
		registro = this.registroService.findByAlumnoAndSolicitud(alumno, solicitud);
		Assert.isNull(registro);

		registro = this.registroService.createRegistration(solicitud);
		alumno.addRegistro(registro);
		solicitud.addRegistro(registro);

		this.alumnoRepository.save(alumno);
		this.solicitudService.save(solicitud);
		this.registroService.save(registro);
	}

	public void unregisterPrincipal(int solicitudId) {
		Assert.isTrue(solicitudId != 0);

		Alumno alumno;
		Solicitud solicitud;
		Registro registro;
		Date currentDate;

		alumno = this.findByPrincipal();
		Assert.notNull(alumno);
		solicitud = this.solicitudService.findOne(solicitudId);
		Assert.notNull(solicitud);
		registro = this.registroService.findByAlumnoAndSolicitud(alumno, solicitud);
		Assert.notNull(registro);

		currentDate = new Date();
		Assert.isTrue(currentDate.before(solicitud.getMomentoSolicitud()));

		alumno.removeRegistro(registro);
		solicitud.removeRegistro(registro);

		this.alumnoRepository.save(alumno);
		this.solicitudService.save(solicitud);
		this.registroService.delete(registro);
	}

	public TarjetaCredito findTarjetaOne(int alumnoId) {
		TarjetaCredito result;

		result = this.alumnoRepository.findTarjetaByUserAccountId(alumnoId);

		return result;
	}

	public TarjetaCredito saveTarjeta(TarjetaCredito tarjeta) {
		Assert.notNull(tarjeta);

		TarjetaCredito result;

		result = this.tarjetaRepository.save(tarjeta);

		return result;
	}
	// Other business methods ---------------------------

}
