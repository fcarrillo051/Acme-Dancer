
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.TarjetaCredito;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Integer> {

	@Query("select e from TarjetaCredito e where e.nombreTitular = ?1")
	Collection<TarjetaCredito> findByNombreTitular(String nombreTitular);

	@Query("select e from TarjetaCredito e where e.marca = ?1")
	Collection<TarjetaCredito> findByMarca(String marca);

	@Query("select e from TarjetaCredito e where e.numero = ?1")
	Collection<TarjetaCredito> findByNumero(String numero);

	@Query("select e from TarjetaCredito e where e.mesCad = ?1")
	Collection<TarjetaCredito> findBymesCad(Integer mesCad);

	@Query("select e from TarjetaCredito e where e.anioCad = ?1")
	Collection<TarjetaCredito> findByAnioCad(Integer anioCad);

	@Query("select e from TarjetaCredito e where e.cvv = ?1")
	Collection<TarjetaCredito> findByCvv(Integer cvv);

}
