
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Curso;
import repositories.CursoRepository;

@Component
@Transactional
public class StringToCursoConverter implements Converter<String, Curso> {

	@Autowired
	CursoRepository cursoRepository;


	@Override
	public Curso convert(final String text) {
		Curso result;
		int id;
		try {
			id = Integer.valueOf(text);
			result = this.cursoRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
