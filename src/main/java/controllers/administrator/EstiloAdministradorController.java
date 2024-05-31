
package controllers.administrator;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
}
