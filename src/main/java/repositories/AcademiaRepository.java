
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Academia;
import domain.Curso;

public interface AcademiaRepository extends JpaRepository<Academia, Integer> {

	@Query("select a from Academia a where a.nombreComercial = ?1")
	Collection<Academia> findByNombreComercial(String nombreComercial);

	@Query("select a from Academia a where a.userAccount.id = ?1")
	Academia findByUserAccountId(int userAccountId);

	@Query("SELECT a FROM Academia a JOIN a.cursos c WHERE c = :curso")
	Collection<Academia> findByCurso(Curso curso);

}
