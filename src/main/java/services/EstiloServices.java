
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Estilo;
import repositories.EstiloRepository;

@Service
@Transactional
public class EstiloServices {

	// Managed repository -------------------------------
	@Autowired
	private EstiloRepository estiloRepository;


	// Simple CRUD methods ------------------------------
	public Estilo create() {
		return new Estilo();
	}

	public Collection<Estilo> findAll() {
		return this.estiloRepository.findAll();
	}

	public Estilo findOne(int estiloId) {
		return this.estiloRepository.findOne(estiloId);
	}

	public Estilo save(Estilo estilo) {
		return this.estiloRepository.save(estilo);
	}

	public void delete(Estilo estilo) {
		this.estiloRepository.delete(estilo);
	}

	// Other business methods ---------------------------
}
