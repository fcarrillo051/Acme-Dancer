
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Registro;

public interface RegistroRepository extends JpaRepository<Registro, Integer> {

	@Query("select r from Registro r where r.solicitud.id = ?1")
	Collection<Registro> findBySolicitudId(int solicitudId);

	@Query("select r from Registro r where r.dueño.id = ?1 and r.solicitud.id = ?2")
	Registro findByAlumnoIdAndSolicitudId(int alumnoId, int announcementId);

}
