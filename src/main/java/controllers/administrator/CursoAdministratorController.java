
package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Curso;
import services.CursoService;

@Controller
@RequestMapping("/curso/administrator")
public class CursoAdministratorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private CursoService cursoService;


	// Constructors -----------------------------------------------------------

	public CursoAdministratorController() {
		super();
	}

	// Listing ----------------------------------------------------------------

	//Listar Cursos
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Curso> cursos;

		cursos = this.cursoService.findAll();

		result = new ModelAndView("curso/list");
		result.addObject("cursos", cursos);
		result.addObject("requestURI", "curso/administrator/list.do");

		return result;
	}

}
