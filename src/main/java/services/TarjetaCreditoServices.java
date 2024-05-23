
package services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.TarjetaCredito;
import repositories.TarjetaCreditoRepository;

@Service
@Transactional
public class TarjetaCreditoServices {

	// Managed repository -------------------------------
	@Autowired
	private TarjetaCreditoRepository tarjetaCreditoRepository;


	// Simple CRUD methods ------------------------------
	public TarjetaCredito create() {
		return new TarjetaCredito();
	}

	public Collection<TarjetaCredito> findAll() {
		return this.tarjetaCreditoRepository.findAll();
	}

	public TarjetaCredito findOne(int tarjetaCreditoId) {
		return this.tarjetaCreditoRepository.findOne(tarjetaCreditoId);
	}

	public TarjetaCredito save(TarjetaCredito tarjetaCredito) {
		return this.tarjetaCreditoRepository.save(tarjetaCredito);
	}

	public void delete(TarjetaCredito tarjetaCredito) {
		this.tarjetaCreditoRepository.delete(tarjetaCredito);
	}

	// Other business methods ---------------------------
}
