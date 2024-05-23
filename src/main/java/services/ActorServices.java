
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Actor;
import repositories.ActorRepository;

@Service
@Transactional
public class ActorServices {

	// Managed repository -------------------------------
	@Autowired
	private ActorRepository actorRepository;


	// Simple CRUD methods ------------------------------
	/*
	 * public Actor create() {//pregutar ponce
	 * return new Actor() {
	 * };
	 * }
	 */
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

}
