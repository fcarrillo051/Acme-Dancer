
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Alumno;

@Component
@Transactional
public class AlumnoToStringConverter implements Converter<Alumno, String> {

	@Override
	public String convert(final Alumno alumno) {
		String result;
		if (alumno == null)
			result = null;
		else
			result = String.valueOf(alumno.getId());
		return result;
	}

}
