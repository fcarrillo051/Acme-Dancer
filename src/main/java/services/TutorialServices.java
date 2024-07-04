
package services;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Academia;
import domain.Tutorial;
import repositories.AcademiaRepository;
import repositories.TutorialRepository;

@Service
@Transactional
public class TutorialServices {

	// Managed repository -------------------------------
	@Autowired
	private TutorialRepository	tutorialRepository;

	@Autowired
	private AcademiaRepository	academiaRepository;


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

	public Map<String, Double> getStatsTutorialesPorAcademia() {
		List<Academia> academias = this.academiaRepository.findAll();
		List<Integer> TutorialesPorAcademia = academias.stream().map(a -> a.getTutoriales().size()).collect(Collectors.toList());

		return this.calculateStatistics(TutorialesPorAcademia);
	}

	public Map<String, Double> getStatsVisitasPorTutoriales() {
		List<Academia> academias = this.academiaRepository.findAll();
		List<Tutorial> tutoriales = academias.stream().flatMap(a -> a.getTutoriales().stream()).collect(Collectors.toList());
		List<Integer> visitasPorTutoriales = tutoriales.stream().map(Tutorial::getVisitas).collect(Collectors.toList());

		return this.calculateStatistics(visitasPorTutoriales);
	}

	public List<Tutorial> getTutorialesOrdenadosPorVisitas() {
		List<Academia> academias = this.academiaRepository.findAll();
		List<Tutorial> tutoriales = academias.stream().flatMap(a -> a.getTutoriales().stream()).collect(Collectors.toList());
		return tutoriales.stream().sorted(Comparator.comparingInt(Tutorial::getVisitas)).collect(Collectors.toList());

	}

	private Map<String, Double> calculateStatistics(List<Integer> data) {
		Map<String, Double> stats = new HashMap<>();
		if (data.isEmpty()) {
			stats.put("min", 0.0);
			stats.put("max", 0.0);
			stats.put("avg", 0.0);
			return stats;
		}

		double min = Collections.min(data);
		double max = Collections.max(data);
		double avg = data.stream().mapToDouble(a -> a).average().orElse(0.0);

		stats.put("min", min);
		stats.put("max", max);
		stats.put("avg", avg);

		return stats;
	}
}
