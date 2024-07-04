/*
 * /*
 * AdministratorController.java
 *
 * Copyright (C) 2018 Universidad de Sevilla
 *
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.CursoService;
import services.TutorialServices;

@Controller
@RequestMapping("/administrator")
public class AdministratorController extends AbstractController {

	@Autowired
	private CursoService		cursoService;

	@Autowired
	private TutorialServices	tutorialService;


	// Constructors -----------------------------------------------------------

	public AdministratorController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping("/action-1")
	public ModelAndView action1() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-1");

		return result;
	}

	// Action-2 ---------------------------------------------------------------

	@RequestMapping("/action-2")
	public ModelAndView action2() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-2");

		return result;
	}

	@RequestMapping("/action-3")
	public ModelAndView action3() {
		ModelAndView result;

		result = new ModelAndView("administrator/action-3");

		return result;
	}

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		ModelAndView result;

		Map<String, Double> statsCursosPorAcademia = this.cursoService.getStatsCursosPorAcademia();
		Map<String, Double> statsSolicitudesPorCurso = this.cursoService.getStatsSolicitudesPorCurso();
		Map<String, Double> statsTutorialesPorAcademia = this.tutorialService.getStatsTutorialesPorAcademia();
		Map<String, Double> StatsVisitasPorTutoriales = this.tutorialService.getStatsVisitasPorTutoriales();

		result = new ModelAndView("administrator/dashboard");
		result.addObject("statsCursosPorAcademia", statsCursosPorAcademia);
		result.addObject("statsSolicitudesPorCurso", statsSolicitudesPorCurso);
		result.addObject("statsTutorialesPorAcademia", statsTutorialesPorAcademia);
		result.addObject("StatsVisitasPorTutoriales", StatsVisitasPorTutoriales);
		result.addObject("requestURI", "administrator/dashboard.do");

		return result;
	}

}
