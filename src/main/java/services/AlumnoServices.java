
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;
import repositories.AlumnoRepository;

@Service
@Transactional
public class AlumnoServices {

	// Managed repository -------------------------------
	@Autowired
	private AlumnoRepository alumnoRepository;


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

	// Other business methods ---------------------------
}
