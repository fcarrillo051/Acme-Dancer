package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import repositories.SuscripcionRepository;
import domain.Suscripcion;

@Service
@Transactional
public class SuscripcionService {

	// Managed repository -----------------------------------------------------

	@Autowired
	private SuscripcionRepository		suscripcionRepository;

	// Supporting services ----------------------------------------------------


	// Constructors -----------------------------------------------------------

	public SuscripcionService() {
		super();
	}

	// Simple CRUD methods ----------------------------------------------------

	public Collection<Suscripcion> findAll() {
		Collection<Suscripcion> result;

		result = suscripcionRepository.findAll();
		Assert.notNull(result);

		return result;
	}
	

	public Suscripcion findOne(int actorId) {
		Assert.isTrue(actorId != 0);

		Suscripcion result;

		result = suscripcionRepository.findOne(actorId);
		Assert.notNull(result);

		return result;
	}

	public Suscripcion save(Suscripcion actor) {
		Assert.notNull(actor);

		Suscripcion result;

		result = suscripcionRepository.save(actor);

		return result;
	}

	public void delete(Suscripcion actor) {
		Assert.notNull(actor);
		Assert.isTrue(actor.getId() != 0);
		Assert.isTrue(suscripcionRepository.exists(actor.getId()));

		suscripcionRepository.delete(actor);
	}

	
}