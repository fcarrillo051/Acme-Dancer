
package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Tutorial;
import services.AcademiaService;
import services.TutorialServices;

@Controller
@RequestMapping("/tutorial/administrador")
public class TutorialAdministradorController extends AbstractController {

	// Services ---------------------------------------------------------------
	@Autowired
	private AcademiaService		academiaService;

	@Autowired
	private TutorialServices	tutorialService;


	// Constructors -----------------------------------------------------------

	public TutorialAdministradorController() {
		super();
	}

	//list ---------------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;

		Collection<Tutorial> tutoriales;

		tutoriales = this.tutorialService.getTutorialesOrdenadosPorVisitas();

		result = new ModelAndView("tutorial/list");
		result.addObject("tutoriales", tutoriales);
		result.addObject("requestURI", "tutorial/administrador/list.do");

		return result;
	}

}
