
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Estilo;
import services.EstiloService;

@Controller
@RequestMapping("/estilo")
public class EstiloController extends AbstractController {

	@Autowired
	private EstiloService estiloService;


	public EstiloController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Estilo> estilos;

		estilos = this.estiloService.findAll();

		result = new ModelAndView("estilo/list");
		result.addObject("estilos", estilos);
		result.addObject("requestURI", "estilo/list.do");

		return result;
	}
}
