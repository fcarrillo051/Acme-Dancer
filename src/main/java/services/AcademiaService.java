
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Academia;
import domain.Curso;
import repositories.AcademiaRepository;

@Service
@Transactional
public class AcademiaService {

	// Managed repository -------------------------------
	@Autowired
	private AcademiaRepository academiaRepository;


	// Simple CRUD methods ------------------------------
	public Academia create() {//pregutar ponce
		return new Academia();
	}
	public Collection<Academia> findAll() {
		return this.academiaRepository.findAll();
	}
	public Academia findOne(int academiaId) {
		return this.academiaRepository.findOne(academiaId);
	}
	public Academia save(Academia academia) {

		return this.academiaRepository.save(academia);
	}
	public void delete(Academia academia) {

		this.academiaRepository.delete(academia);
	}

	public Collection<Academia> findByCurso(Curso curso) {
		return this.academiaRepository.findByCurso(curso);
	}

	// Other business methods ---------------------------

}
