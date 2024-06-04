
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Academia;

@Component
@Transactional
public class AcademiaToStringConverter implements Converter<Academia, String> {

	@Override
	public String convert(Academia academia) {
		String result;
		if (academia == null)
			result = null;
		else
			result = String.valueOf(academia.getId());
		return result;
	}

}
