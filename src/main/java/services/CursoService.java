
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Curso;
import repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	// Managed repository -------------------------------
	@Autowired
	private CursoRepository cursoRepository;


	// Simple CRUD methods ------------------------------
	public Curso create() {
		return new Curso();
	}

	public Collection<Curso> findAll() {
		return this.cursoRepository.findAll();
	}

	public Curso findOne(int cursoId) {
		return this.cursoRepository.findOne(cursoId);
	}

	public Curso save(Curso curso) {
		return this.cursoRepository.save(curso);
	}

	public void delete(Curso curso) {
		this.cursoRepository.delete(curso);
	}

	// Other business methods ---------------------------
}
