
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Solicitud;
import repositories.SolicitudRepository;

@Component
@Transactional
public class StringToSolicitudConverter implements Converter<String, Solicitud> {

	@Autowired
	SolicitudRepository solicitudRepository;


	@Override
	public Solicitud convert(final String text) {
		Solicitud result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = this.solicitudRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
