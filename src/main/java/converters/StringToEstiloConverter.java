/*
 * StringToEstiloConverter.java
 * 
 * Copyright (C) 2017 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import repositories.EstiloRepository;
import domain.Estilo;

@Component
@Transactional
public class StringToEstiloConverter implements Converter<String, Estilo> {

	@Autowired
	EstiloRepository	estiloRepository;


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
