
package repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Curso;
import domain.DiaImpartido;
import domain.Nivel;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {

	@Query("select c from Curso c where c.titulo = ?1")
	Collection<Curso> findByTitulo(String titulo);

	@Query("select c from Curso c where c.nivel = ?1")
	Collection<Curso> findByNivel(Nivel nivel);

	@Query("select c from Curso c where c.fechaInicio = ?1")
	Collection<Curso> findByfechaInicio(Date fechaInicio);

	@Query("select c from Curso c where c.fechaFinal = ?1")
	Collection<Curso> findByfechaFinal(Date fechaFinal);

	@Query("select c from Curso c where c.diaImpartido = ?1")
	Collection<Curso> findBydiaImpartido(DiaImpartido diaImpartido);

	@Query("select c from Curso c where c.horaImpartido = ?1")
	Collection<Curso> findByhoraImpartida(Date horaImpartida);

}
