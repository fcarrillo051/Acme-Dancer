
package controllers.academia;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Academia;
import domain.Tutorial;
import services.AcademiaService;
import services.TutorialServices;

@Controller
@RequestMapping("/tutorial/academia")
public class TutorialAcademiaControler extends AbstractController {

	// Services ---------------------------------------------------------------
	@Autowired
	private AcademiaService		academiaService;

	@Autowired
	private TutorialServices	tutorialService;


	// Constructors -----------------------------------------------------------

	public TutorialAcademiaControler() {
		super();
	}

	//list ---------------------------------------------------------------------
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listCRUD() {
		ModelAndView result;

		Collection<Tutorial> tutoriales;
		Academia academia;

		academia = this.academiaService.findByPrincipal();

		tutoriales = this.tutorialService.findByAcademia(academia.getId());

		result = new ModelAndView("tutorial/list");
		result.addObject("tutoriales", tutoriales);
		result.addObject("requestURI", "tutorial/academia/list.do");

		return result;
	}

}
