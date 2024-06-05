
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Curso;
import domain.Solicitud;
import services.CursoService;
import services.SolicitudService;

@Controller
@RequestMapping("/curso")
public class CursoController extends AbstractController {

	@Autowired
	private CursoService		cursoService;
	@Autowired
	private SolicitudService	solicitudService;


	public CursoController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Curso> cursos;

		cursos = this.cursoService.findAll();

		result = new ModelAndView("curso/list");
		result.addObject("cursos", cursos);
		result.addObject("requestURI", "curso/list.do");

		return result;
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public ModelAndView info(@RequestParam("cursoId") int cursoId) {
		ModelAndView result;
		Curso curso;

		curso = this.cursoService.findOne(cursoId);

		result = new ModelAndView("curso/info");
		result.addObject("curso", curso);

		return result;
	}

	@RequestMapping(value = "/solicitar", method = RequestMethod.POST)
	public ModelAndView solicitar(@RequestParam final int cursoId) {
		ModelAndView result;
		Curso curso;

		curso = this.cursoService.findOne(cursoId);
		if (this.solicitudService.findByAlumnoAndCurso(curso) == null) {

			Solicitud sol = this.solicitudService.createSolicitud(curso);
			this.solicitudService.save(sol);
			result = new ModelAndView("redirect:/solicitud/list-alumn.do");

			return result;
		}
		return null;
	}
}
