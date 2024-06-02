
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.TarjetaCredito;
import repositories.TarjetaCreditoRepository;

@Component
@Transactional
public class StringToTarjetaCreditoConverter implements Converter<String, TarjetaCredito> {

	@Autowired
	TarjetaCreditoRepository tarjetaCreditoRepository;


	@Override
	public TarjetaCredito convert(final String text) {
		TarjetaCredito result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = this.tarjetaCreditoRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
