
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Academia;
import repositories.AcademiaRepository;

@Component
@Transactional
public class StringToAcademiaConverter implements Converter<String, Academia> {

	@Autowired
	AcademiaRepository academiaRepository;


	@Override
	public Academia convert(final String text) {
		Academia result;
		int id;
		try {
			id = Integer.valueOf(text);
			result = this.academiaRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
