
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Estilo;

public interface EstiloRepository extends JpaRepository<Estilo, Integer> {

	@Query("select e from Estilo e where e.titulo = ?1")
	Collection<Estilo> findByTitulo(String titulo);

	@Query("select e from Estilo e where e.descripcion = ?1")
	Collection<Estilo> findByDescripcion(String descripcion);

	@Query("select e from Estilo e where e.videos = ?1")
	Collection<Estilo> findByVideos(Collection<String> videos);

	@Query("select e from Estilo e where e.imagenes = ?1")
	Collection<Estilo> findByImagenes(Collection<String> imagenes);

}
