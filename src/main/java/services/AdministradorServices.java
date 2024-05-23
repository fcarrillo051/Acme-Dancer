
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Administrador;
import repositories.AdministradorRepository;

@Service
@Transactional
public class AdministradorServices {

	// Managed repository -------------------------------
	@Autowired
	private AdministradorRepository administradorRepository;


	// Simple CRUD methods ------------------------------
	public Administrador create() {//pregutar ponce
		return new Administrador();
	}
	public Collection<Administrador> findAll() {
		return this.administradorRepository.findAll();
	}
	public Administrador findOne(int adminId) {
		return this.administradorRepository.findOne(adminId);
	}
	public Administrador save(Administrador admin) {

		return this.administradorRepository.save(admin);
	}
	public void delete(Administrador admin) {

		this.administradorRepository.delete(admin);
	}

	// Other business methods ---------------------------

}
