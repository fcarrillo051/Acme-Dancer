
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {

	@Query("select e from Tutorial e where e.titulo = ?1")
	Collection<Tutorial> findByTitulo(String titulo);

	@Query("select e from Tutorial e where e.descripcion = ?1")
	Collection<Tutorial> findByDescripcion(String descripcion);

	@Query("select e from Tutorial e where e.video = ?1")
	Collection<Tutorial> findByVideo(String video);

	@Query("select e from Tutorial e where academia_id = ?1")
	Collection<Tutorial> findByAcademia(int academiaId);

}
