
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Suscripcion;

@Repository
public interface SuscripcionRepository extends JpaRepository<Suscripcion, Integer> {

}