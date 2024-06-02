
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import domain.Tutorial;
import repositories.TutorialRepository;

@Component
@Transactional
public class StringToTutorialConverter implements Converter<String, Tutorial> {

	@Autowired
	TutorialRepository tutorialRepository;


	@Override
	public Tutorial convert(final String text) {
		Tutorial result;
		int id;

		try {
			id = Integer.valueOf(text);
			result = this.tutorialRepository.findOne(id);
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return result;
	}

}
