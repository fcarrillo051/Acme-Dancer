
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Alumno;
import domain.TarjetaCredito;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

	@Query("select a from Alumno a where a.userAccount.id = ?1")
	Alumno findByUserAccountId(int id);

	@Query("select c.tarjetaCredito from Alumno c where c.userAccount.id = ?1")
	TarjetaCredito findTarjetaByUserAccountId(int userAccountId);

}
