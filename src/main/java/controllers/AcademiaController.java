/*
 * CustomerController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import services.AcademiaService;

@Controller
@RequestMapping("/academia")
public class AcademiaController extends AbstractController {

	@Autowired
	private AcademiaService academiaService;


	// Constructors -----------------------------------------------------------

	public AcademiaController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("academia/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("academia/action-2");

		return result;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Academia> academias;

		academias = this.academiaService.findAll();

		result = new ModelAndView("academia/list");
		result.addObject("academias", academias);
		result.addObject("requestURI", "academia/list.do");

		return result;
	}

}
