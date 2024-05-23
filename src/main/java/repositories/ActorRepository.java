
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

	@Query("select a from Actor a where a.nombre = ?1")
	Collection<Actor> findByNombre(String nombre);

	@Query("select a from Actor a where a.apellidos = ?1")
	Collection<Actor> findByApellido(String apellido);

	@Query("select a from Actor a where a.correoElectronico = ?1")
	Collection<Actor> findByEmail(String email);

	@Query("select a from Actor a where a.numTelefono = ?1")
	Collection<Actor> findByNumTelefono(String telefono);

	@Query("select a from Actor a where a.codigoPostal = ?1")
	Collection<Actor> findByCodigoPostal(Integer codigoPostal);
}
