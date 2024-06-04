
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Solicitud;

@Component
@Transactional
public class SolicitudToStringConverter implements Converter<Solicitud, String> {

	@Override
	public String convert(final Solicitud solicitud) {
		String result;

		if (solicitud == null)
			result = null;
		else
			result = String.valueOf(solicitud.getId());

		return result;
	}

}
