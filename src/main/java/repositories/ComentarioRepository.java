
package repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	@Query("select c from Comentario c where c.actores.id = ?1")
	Collection<Comentario> findByActorId(int actorId);
	
	@Query("select s.creador.id from Suscripcion s where s.suscriptor.id = ?1")
	Collection<Integer> findCreadorIdByActorId(int actorId);
	
	@Query("select s.suscriptor.id from Suscripcion s where s.creador.id = ?1")
	Collection<Integer> findSuscriptorIdIdByActorId(int actorId);
	
    @Query("select c from Comentario c order by c.fechaCom asc")
    List<Comentario> listComentariosOrderedDesc();
	
	@Override
    @Query("select c from Comentario c")
    List<Comentario> findAll();
}
