
package controllers.academia;

import java.util.Collection;

import javax.validation.Valid;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView list() {
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

	@RequestMapping(value = "/listFromAcademia", method = RequestMethod.GET)
	public ModelAndView listAcademia(@RequestParam final int academiaId) {
		ModelAndView result;

		Collection<Tutorial> tutoriales;

		tutoriales = this.tutorialService.findByAcademia(academiaId);

		result = new ModelAndView("tutorial/list");
		result.addObject("tutoriales", tutoriales);
		result.addObject("requestURI", "tutorial/academia/list.do");

		return result;
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Tutorial tutorial;

		tutorial = this.tutorialService.create();
		result = this.createEditModelAndView(tutorial);

		return result;
	}

	//Edit ---------------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int tutorialId) {
		ModelAndView result;
		Tutorial tutorial;

		tutorial = this.tutorialService.findOne(tutorialId);
		Assert.assertNotNull(tutorial);
		result = this.createEditModelAndView(tutorial);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Tutorial tutorial, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(tutorial);
		else
			try {
				this.tutorialService.save(tutorial);
				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(tutorial, "tutorial.commit.error");
			}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Tutorial tutorial, final BindingResult binding) {
		ModelAndView result;

		try {
			this.tutorialService.delete(tutorial);
			result = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(tutorial, "tutorial.commit.error");
		}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Tutorial tutorial) {
		ModelAndView result;

		result = this.createEditModelAndView(tutorial, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Tutorial tutorial, final String message) {
		ModelAndView result;

		Academia academia;

		academia = this.academiaService.findByPrincipal();
		tutorial.setAcademia(academia);

		result = new ModelAndView("tutorial/edit");
		result.addObject("tutorial", tutorial);
		result.addObject("message", message);

		return result;
	}

}
