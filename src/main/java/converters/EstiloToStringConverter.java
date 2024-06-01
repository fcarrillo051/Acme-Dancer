
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Estilo;

@Component
@Transactional
public class EstiloToStringConverter implements Converter<Estilo, String> {

	@Override
	public String convert(final Estilo estilo) {
		String result;
		if (estilo == null)
			result = null;
		else
			result = String.valueOf(estilo.getId());
		return result;
	}

}
