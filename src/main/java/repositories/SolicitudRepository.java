
package repositories;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.EstadoSolicitud;
import domain.Solicitud;

public interface SolicitudRepository extends JpaRepository<Solicitud, Integer> {

	@Query("select e from Solicitud e where e.momentoSolicitud = ?1")
	Collection<Solicitud> findByMomentoSolicitud(Date momentoSolicitud);

	@Query("select e from Solicitud e where e.estadoSolicitud = ?1")
	Collection<Solicitud> findByEstadoSolicitud(EstadoSolicitud estadoSolicitud);

}
