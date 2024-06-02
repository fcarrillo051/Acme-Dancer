
package services;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.Academia;
import domain.Curso;
import domain.Estilo;
import repositories.AcademiaRepository;
import repositories.CursoRepository;

@Service
@Transactional
public class CursoService {

	// Managed repository -------------------------------
	@Autowired
	private CursoRepository		cursoRepository;
	@Autowired
	private AcademiaRepository	academiaRepository;


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

	public Collection<Curso> findByEstilo(Estilo estilo) {
		return this.cursoRepository.findByEstilo(estilo);
	}

	// Other business methods ---------------------------

	public Map<String, Double> getStatsCursosPorAcademia() {
		List<Academia> academias = this.academiaRepository.findAll();
		List<Integer> cursosPorAcademia = academias.stream().map(a -> a.getCursos().size()).collect(Collectors.toList());

		return this.calculateStatistics(cursosPorAcademia);
	}

	public Map<String, Double> getStatsSolicitudesPorCurso() {
		List<Curso> cursos = this.cursoRepository.findAll();
		List<Integer> solicitudesPorCurso = cursos.stream().map(c -> c.getSolicitudes().size()).collect(Collectors.toList());

		return this.calculateStatistics(solicitudesPorCurso);
	}

	private Map<String, Double> calculateStatistics(List<Integer> data) {
		Map<String, Double> stats = new HashMap<>();
		if (data.isEmpty()) {
			stats.put("min", 0.0);
			stats.put("max", 0.0);
			stats.put("avg", 0.0);
			stats.put("stddev", 0.0);
			return stats;
		}

		double min = Collections.min(data);
		double max = Collections.max(data);
		double avg = data.stream().mapToDouble(a -> a).average().orElse(0.0);
		double variance = data.stream().mapToDouble(a -> Math.pow(a - avg, 2)).average().orElse(0.0);
		double stddev = Math.sqrt(variance);

		stats.put("min", min);
		stats.put("max", max);
		stats.put("avg", avg);
		stats.put("stddev", stddev);

		return stats;
	}

}
