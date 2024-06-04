
package controllers.academia;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Academia;
import domain.Curso;
import services.AcademiaService;
import services.CursoService;

@Controller
@RequestMapping("/curso/academia")
public class CursoAcademiaController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private AcademiaService academiaService;
	@Autowired
	private CursoService cursoService;

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

	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView result;
		Curso curso;

		curso = this.cursoService.create();
		result = new ModelAndView("curso/add");
		result.addObject("curso", curso);
		result.addObject("requestURI", "curso/academia/add.do");

		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, params = "save")
	public ModelAndView add(@Valid final Curso curso, final BindingResult bindig) {
		ModelAndView result;

		if (bindig.hasErrors())
			result = this.createEditModelAndView(curso);
		else
			try {
				this.cursoService.save(curso);
				result = new ModelAndView("redirect: listCRUD.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(curso, "curso.commit.error");
			}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Curso curso) {
		ModelAndView result;

		result = this.createEditModelAndView(curso, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Curso curso, final String message) {
		ModelAndView result;

		Collection<Academia> academias;
		academias = this.academiaService.findAll();

		result = new ModelAndView("curso/edit");
		result.addObject("curso", curso);
		result.addObject("academias", academias);
		result.addObject("message", message);

		return result;
	}

}
