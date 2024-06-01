
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.Actor;
import services.ActorServices;

@Controller
@RequestMapping("/actor")
public class ActorController extends AbstractController {

	@Autowired
	private ActorServices actorService;


	public ActorController() {
		super();
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Actor> actores;

		actores = this.actorService.findAll();

		result = new ModelAndView("estilo/list");
		result.addObject("estilos", estilos);
		result.addObject("requestURI", "estilo/list.do");

		return result;
	}
}
