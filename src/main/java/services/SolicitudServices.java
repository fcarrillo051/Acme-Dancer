
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Solicitud;
import repositories.SolicitudRepository;

@Service
@Transactional
public class SolicitudServices {

	// Managed repository -------------------------------
	@Autowired
	private SolicitudRepository solicitudRepository;


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

	// Other business methods ---------------------------
}
