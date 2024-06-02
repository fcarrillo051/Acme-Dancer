
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Estilo;
import repositories.EstiloRepository;

@Component
@Transactional
public class StringToEstiloConverter implements Converter<String, Estilo> {

	@Autowired
	EstiloRepository estiloRepository;


	@Override
	public Estilo convert(final String text) {
		Estilo result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = this.estiloRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
