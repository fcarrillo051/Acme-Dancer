
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;
import repositories.AlumnoRepository;

@Component
@Transactional
public class StringToAlumnoConverter implements Converter<String, Alumno> {

	@Autowired
	AlumnoRepository alumnoRepository;


	@Override
	public Alumno convert(final String text) {
		Alumno result;
		int id;
		try {
			id = Integer.valueOf(text);
			result = this.alumnoRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
