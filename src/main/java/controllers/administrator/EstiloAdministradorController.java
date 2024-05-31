
package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Estilo;
import services.EstiloService;

@Controller
@RequestMapping("/estilo/administrator")
public class EstiloAdministradorController extends AbstractController {

	// Services ---------------------------------------------------------------

	@Autowired
	private EstiloService estiloService;


	// Constructors -----------------------------------------------------------

	public EstiloAdministradorController() {
		super();
	}

	// Listing ----------------------------------------------------------------

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

	// Editing ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int estiloId) {
		ModelAndView result;
		Estilo estilo;

		estilo = this.estiloService.findOne(estiloId);
		result = new ModelAndView("estilo/edit");
		result.addObject("estilo", estilo);
		result.addObject("requestURI", "estilo/administrator/edit.do?estiloId=" + estiloId);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView save(Estilo estilo, BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors()) {
			result = new ModelAndView("estilo/edit");
			result.addObject("estilo", estilo);
		} else
			try {
				this.estiloService.save(estilo);
				result = new ModelAndView("redirect:/estilo/administrator/listCRUD.do");
			} catch (Throwable oops) {
				result = new ModelAndView("estilo/edit");
				result.addObject("estilo", estilo);
				result.addObject("message", "estilo.commit.error");
			}

		return result;
	}

}
