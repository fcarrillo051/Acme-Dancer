
package controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Academia;
import domain.Actor;
import domain.Alumno;
import domain.Comentario;
import domain.Suscripcion;
import services.ActorServices;
import services.ComentarioService;
import services.SuscripcionService;

@Controller
@RequestMapping("comentario")
public class ComentarioController extends AbstractController {

	@Autowired
	private ComentarioService	comentarioService;
	@Autowired
	private SuscripcionService	suscripcionService;

	@Autowired
	private ActorServices		actorService;


	// Constructors -----------------------------------------------------------

	public ComentarioController() {
		super();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	// Create -------------------------------------
	@RequestMapping("/create")
	public ModelAndView register(@Valid final Comentario credentials, final BindingResult bindingResult, @RequestParam(required = false) final boolean showError) {
		Assert.notNull(credentials);
		Assert.notNull(bindingResult);

		ModelAndView result;
		credentials.setfechaCom(new Date());
		result = new ModelAndView("comentario/create");
		result.addObject("comentario", credentials);
		Alumno a = this.actorService.findByPrincipalAlumn();
		if (a != null)
			result.addObject("actor", a);
		else {
			Academia ac = this.actorService.findByPrincipalAcademy();
			result.addObject("actor", ac);
		}
		result.addObject("showError", showError);

		return result;
	}

	// Edition ----------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int comentarioId, @RequestParam(required = false) final boolean showError) {
		ModelAndView result;
		Comentario comentario;

		comentario = this.comentarioService.findOne(comentarioId);
		Assert.notNull(comentario);
		result = new ModelAndView("comentario/edit");
		result.addObject("comentario", comentario);
		Alumno a = this.actorService.findByPrincipalAlumn();
		if (a != null)
			result.addObject("actor", a);
		else {
			Academia ac = this.actorService.findByPrincipalAcademy();
			result.addObject("actor", ac);
		}
		result.addObject("showError", showError);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Comentario comentario, final BindingResult binding) {
		ModelAndView result;
		System.out.println("entra");
		if (binding.hasErrors()) {
			System.out.println("tiene error");
			result = new ModelAndView("comentario/edit");
			result.addObject("comentario", comentario);
			Alumno a = this.actorService.findByPrincipalAlumn();
			if (a != null)
				result.addObject("actor", a);
			else {
				Academia ac = this.actorService.findByPrincipalAcademy();
				result.addObject("actor", ac);
			}
			result.addObject("showError", true);
			// Imprimir errores en la consola
			for (ObjectError error : binding.getAllErrors())
				if (error instanceof FieldError) {
					FieldError fieldError = (FieldError) error;
					System.out.println("Field error in object '" + fieldError.getObjectName() + "' on field '" + fieldError.getField() + "': " + fieldError.getDefaultMessage());
				} else
					System.out.println("Error in object '" + error.getObjectName() + "': " + error.getDefaultMessage());
		} else
			try {
				this.comentarioService.save(comentario);
				result = new ModelAndView("redirect:list.do");
			} catch (Exception e) {
				System.out.println("tiene error de guardado");
				System.out.println(e.getMessage());
				result = new ModelAndView("comentario/edit");
				result.addObject("comentario", comentario);
				Alumno a = this.actorService.findByPrincipalAlumn();
				if (a != null)
					result.addObject("actor", a);
				else {
					Academia ac = this.actorService.findByPrincipalAcademy();
					result.addObject("actor", ac);
				}
				result.addObject("showError", true);
			}

		return result;
	}

	// List ---------------------------------------------------------------

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Comentario> comentarios = new ArrayList<Comentario>();
		comentarios = this.comentarioService.findAll();

		result = new ModelAndView("comentario/list");
		result.addObject("requestURI", "comentario/list.do");
		result.addObject("comentarios", comentarios);

		return result;
	}

	@RequestMapping(value = "/list-actor", method = RequestMethod.GET)
	public ModelAndView list_actor() {
		ModelAndView result;
		Collection<Comentario> comentarioes = new ArrayList<Comentario>();
		;

		Actor a = this.actorService.findByPrincipalAlumn();
		if (a != null)
			comentarioes = this.comentarioService.findByActorId(a.getId());
		else {
			Academia ac = this.actorService.findByPrincipalAcademy();
			comentarioes = this.comentarioService.findByActorId(ac.getId());
		}

		result = new ModelAndView("comentario/list-actor");
		result.addObject("requestURI", "comentario/list-actor.do");
		result.addObject("comentarios", comentarioes);

		return result;
	}

	@RequestMapping(value = "/list-suscriptor", method = RequestMethod.GET)
	public ModelAndView list_suscriptor() {
		ModelAndView result;
		Collection<Comentario> comentarioes = new ArrayList<Comentario>();
		;

		Actor a = this.actorService.findByPrincipalAlumn();
		if (a != null)
			comentarioes = this.comentarioService.findCommentsSuscription(a.getId());
		else {
			Academia ac = this.actorService.findByPrincipalAcademy();
			comentarioes = this.comentarioService.findCommentsSuscription(ac.getId());
		}

		result = new ModelAndView("comentario/list-suscriptor");
		result.addObject("requestURI", "comentario/list-suscriptor.do");
		result.addObject("comentarios", comentarioes);

		return result;
	}
	@RequestMapping(value = "/list-actor-suscriptor", method = RequestMethod.GET)
	public ModelAndView list_actor_suscriptor() {
		ModelAndView result;
		Collection<Integer> comentarioes = new ArrayList<Integer>();

		Actor a = this.actorService.findByPrincipalAlumn();
		if (a != null)
			comentarioes = this.comentarioService.findActoresSuscription(a.getId());
		else {
			Academia ac = this.actorService.findByPrincipalAcademy();
			comentarioes = this.comentarioService.findActoresSuscription(ac.getId());
		}
		ArrayList<Actor> actor = new ArrayList<Actor>();
		for (Integer i : comentarioes)
			actor.add(this.actorService.findOne(i));

		result = new ModelAndView("comentario/list-actor-suscriptor");
		result.addObject("requestURI", "comentario/list-actor-suscriptor.do");
		result.addObject("actores", actor);

		return result;
	}

	@RequestMapping(value = "/suscribirse", method = RequestMethod.POST)
	public ModelAndView solicitar(@RequestParam final int actorId) {
		ModelAndView result;

		Actor creador = this.actorService.findOne(actorId);
		Actor suscriptor = this.actorService.findByPrincipalAlumn();
		if (suscriptor == null)
			suscriptor = this.actorService.findByPrincipalAcademy();

		Suscripcion sus = new Suscripcion();

		System.out.println("Creador " + creador);

		System.out.println("Suscriptor " + suscriptor);

		sus.setCreador(creador);
		sus.setSuscriptor(suscriptor);

		System.out.println("Sucripcion " + sus);

		this.suscripcionService.save(sus);
		result = new ModelAndView("redirect:/comentario/list.do");

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam final int comentarioId) {
		ModelAndView result;
		Comentario comentario = this.comentarioService.findOne(comentarioId);
		try {
			this.comentarioService.delete(comentario);
			result = new ModelAndView("redirect:list.do");
		} catch (Exception e) {
			System.out.println("tiene error de eliminar");
			e.printStackTrace();
		}

		result = new ModelAndView("redirect:/comentario/list.do");
		return result;
	}

}
