
package converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Curso;

@Component
@Transactional
public class CursoToStringConverter implements Converter<Curso, String> {

	@Override
	public String convert(final Curso curso) {
		String result;
		if (curso == null)
			result = null;
		else
			result = String.valueOf(curso.getId());
		return result;
	}

}
