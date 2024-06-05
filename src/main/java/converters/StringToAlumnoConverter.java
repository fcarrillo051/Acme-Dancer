/*
 * StringToAlumnoConverter.java
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

import repositories.AlumnoRepository;
import domain.Alumno;

@Component
@Transactional
public class StringToAlumnoConverter implements Converter<String, Alumno> {

	@Autowired
	AlumnoRepository	alumnoRepository;


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
