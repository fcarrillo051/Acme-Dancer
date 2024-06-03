
package controllers.academia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Curso;
import services.AcademiaService;
import services.CursoService;

@Controller
@RequestMapping("/curso/academia")
public class CursoAcademiaController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private AcademiaService	academiaService;
	@Autowired
	private CursoService	cursoService;


	// Constructors -----------------------------------------------------------

	public CursoAcademiaController() {
		super();
	}

	@RequestMapping(value = "/listCRUD", method = RequestMethod.GET)
	public ModelAndView listCRUD() {
		ModelAndView result;

		Collection<Curso> cursos;

		cursos = this.cursoService.findAll();

		result = new ModelAndView("curso/listCRUD");
		result.addObject("cursos", cursos);
		result.addObject("requestURI", "curso/academia/listCRUD.do");

		return result;
	}

}
