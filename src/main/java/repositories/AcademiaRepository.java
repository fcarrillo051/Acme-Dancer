
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Academia;

public interface AcademiaRepository extends JpaRepository<Academia, Integer> {

	@Query("select a from Academia a where a.nombreComercial = ?1")
	Collection<Academia> findByNombreComercial(String nombreComercial);

}
