
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import domain.Academia;
import domain.Actor;
import domain.Alumno;
import repositories.ActorRepository;
import security.LoginService;
import security.UserAccount;

@Service
@Transactional
public class ActorServices {

	// Managed repository -------------------------------
	@Autowired
	private ActorRepository	actorRepository;

	@Autowired
	private AcademiaService	academiaService;
	@Autowired
	private AlumnoService	alumnoService;


	// Simple CRUD methods ------------------------------

	public Actor create() {//pregutar ponce
		return new Actor() {
		};
	}

	public Collection<Actor> findAll() {
		return this.actorRepository.findAll();
	}
	public Actor findOne(int ActorId) {
		return this.actorRepository.findOne(ActorId);
	}
	public Actor save(Actor actor) {

		return this.actorRepository.save(actor);
	}
	public void delete(Actor actor) {

		this.actorRepository.delete(actor);
	}

	// Other business methods ---------------------------

	public Academia findByPrincipalAcademy() {
		Academia result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = this.academiaService.findByUserAccount(userAccount);

		return result;
	}

	public Alumno findByPrincipalAlumn() {
		Alumno result;
		UserAccount userAccount;

		userAccount = LoginService.getPrincipal();
		Assert.notNull(userAccount);
		result = this.alumnoService.findByUserAccount(userAccount);

		return result;
	}

}
