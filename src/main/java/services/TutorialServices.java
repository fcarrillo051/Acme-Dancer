
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Tutorial;
import repositories.TutorialRepository;

@Service
@Transactional
public class TutorialServices {

	// Managed repository -------------------------------
	@Autowired
	private TutorialRepository tutorialRepository;


	// Simple CRUD methods ------------------------------
	public Tutorial create() {
		return new Tutorial();
	}

	public Collection<Tutorial> findAll() {
		return this.tutorialRepository.findAll();
	}

	public Tutorial findOne(int tutorialId) {
		return this.tutorialRepository.findOne(tutorialId);
	}

	public Tutorial save(Tutorial tutorial) {
		return this.tutorialRepository.save(tutorial);
	}

	public void delete(Tutorial tutorial) {
		this.tutorialRepository.delete(tutorial);
	}

	// Other business methods ---------------------------

	public Collection<Tutorial> findByAcademia(int academiaId) {
		return this.tutorialRepository.findByAcademia(academiaId);
	}
}
