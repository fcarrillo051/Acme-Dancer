
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.TarjetaCredito;;

@Component
@Transactional
public class TarjetaCreditoToStringConverter implements Converter<TarjetaCredito, String> {

	@Override
	public String convert(final TarjetaCredito tarjetaCredito) {
		String result;

		if (tarjetaCredito == null)
			result = null;
		else
			result = String.valueOf(tarjetaCredito.getId());

		return result;
	}

}
