
package controllers;

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

	//Actor ADD hh
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Actor actor;

		actor = this.actorService.create();

		result = new ModelAndView("actor/create");
		result.addObject("actor", actor);
		result.addObject("requestURI", "estilo/list.do");

		return result;
	}
}
