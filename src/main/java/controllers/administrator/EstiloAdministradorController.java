
package controllers.administrator;

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
import domain.Curso;
import domain.Estilo;
import services.CursoService;
import services.EstiloService;

@Controller
@RequestMapping("/estilo/administrator")
public class EstiloAdministradorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private EstiloService	estiloService;
	@Autowired
	private CursoService	cursoService;


	// Constructors -----------------------------------------------------------

	public EstiloAdministradorController() {
		super();
	}

	// Listar ----------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Estilo> estilos;

		estilos = this.estiloService.findAll();

		result = new ModelAndView("estilo/list");
		result.addObject("estilos", estilos);
		result.addObject("requestURI", "estilo/administrator/list.do");

		return result;
	}

	@RequestMapping(value = "/listCRUD", method = RequestMethod.GET)
	public ModelAndView listCRUD() {
		ModelAndView result;
		Collection<Estilo> estilos;

		estilos = this.estiloService.findAll();

		result = new ModelAndView("estilo/listCRUD");
		result.addObject("estilos", estilos);
		result.addObject("requestURI", "estilo/administrator/listCRUD.do");

		return result;
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Estilo estilo;

		estilo = this.estiloService.create();
		result = this.createEditModelAndView(estilo);

		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView result;
		Estilo estilo;

		estilo = this.estiloService.create();
		result = new ModelAndView("estilo/add");
		result.addObject("estilo", estilo);
		result.addObject("requestURI", "estilo/administrator/add.do");

		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, params = "save")
	public ModelAndView add(@Valid final Estilo estilo, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(estilo);
		else
			try {
				this.estiloService.save(estilo);
				result = new ModelAndView("redirect:listCRUD.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(estilo, "estilo.commit.error");
			}

		return result;
	}
	// Edition ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int estiloId) {
		ModelAndView result;
		Estilo estilo;

		estilo = this.estiloService.findOne(estiloId);
		Assert.assertNotNull(estilo);
		result = this.createEditModelAndView(estilo);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Estilo estilo, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(estilo);
		else
			try {
				this.estiloService.save(estilo);
				result = new ModelAndView("redirect:listCRUD.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(estilo, "estilo.commit.error");
			}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Estilo estilo, final BindingResult binding) {
		ModelAndView result;

		try {
			Collection<Curso> cursos = this.cursoService.findByEstilo(estilo);
			if (cursos.isEmpty()) {
				this.estiloService.delete(estilo);
				result = new ModelAndView("redirect:listCRUD.do");
			} else
				result = this.createEditModelAndView(estilo, "estilo.delete.error.cursos");
		} catch (final Throwable oops) {
			result = this.createEditModelAndView(estilo, "estilo.commit.error");
		}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Estilo estilo) {
		ModelAndView result;

		result = this.createEditModelAndView(estilo, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Estilo estilo, final String message) {
		ModelAndView result;

		result = new ModelAndView("estilo/edit");
		result.addObject("estilo", estilo);
		result.addObject("message", message);

		return result;
	}
}
