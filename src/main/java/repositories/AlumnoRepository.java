
package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

}
