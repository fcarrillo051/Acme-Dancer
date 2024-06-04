
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Administrador;
import repositories.AdministradorRepository;

@Component
@Transactional
public class StringToAdministradorConverter implements Converter<String, Administrador> {

	@Autowired
	AdministradorRepository administradorRepository;


	@Override
	public Administrador convert(final String text) {
		Administrador result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = this.administradorRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
