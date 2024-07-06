
package controllers.alumno;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Solicitud;
import services.AlumnoService;
import services.CursoService;
import services.SolicitudService;

@Controller
@RequestMapping("/solicitud/alumno")
public class SolicitudAlumnoController extends AbstractController {

	@Autowired
	private SolicitudService	solicitudService;
	@Autowired
	private AlumnoService		alumnoService;
	@Autowired
	private CursoService		cursoService;


	public SolicitudAlumnoController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Solicitud> solicitudes;
		Collection<Solicitud> solicitudesRegistradas;

		solicitudes = this.solicitudService.findAll();
		solicitudesRegistradas = this.solicitudService.findRegistered();

		result = new ModelAndView("solicitud/list");
		result.addObject("requestURI", "solicitud/alumno/list.do");
		result.addObject("solicitudes", solicitudes);
		result.addObject("solicitudesRegistradas", solicitudesRegistradas);

		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@RequestParam final int solicitudId) {
		ModelAndView result;

		try {
			this.alumnoService.registerPrincipal(solicitudId);
			result = this.list();
			result.addObject("message", "solicitud.commit.ok");
		} catch (final Throwable oops) {
			result = this.list();
			result.addObject("message", "solicitud.commit.error");
		}

		return result;
	}

	@RequestMapping(value = "/unregister", method = RequestMethod.GET)
	public ModelAndView unregister(@RequestParam final int solicitudId) {
		ModelAndView result;

		try {
			this.alumnoService.unregisterPrincipal(solicitudId);
			;
			result = this.list();
			result.addObject("message", "solicitud.commit.ok");
		} catch (final Throwable oops) {
			result = this.list();
			result.addObject("message", "solicitud.commit.error");
		}

		return result;
	}

	// Creation ---------------------------------------------------------------

	//Crear Solicitud
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView result;
		Solicitud solicitud;

		solicitud = this.solicitudService.create();
		result = new ModelAndView("solicitud/add");
		result.addObject("solicitud", solicitud);
		result.addObject("cursos", this.cursoService.findAll());
		result.addObject("alumno", this.alumnoService.findByPrincipal());
		result.addObject("requestURI", "solicitud/alumno/add.do");

		return result;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, params = "save")
	public ModelAndView add(@Valid final Solicitud solicitud, final BindingResult bindig) {
		ModelAndView result;

		if (bindig.hasErrors())
			result = this.createEditModelAndView(solicitud, null);
		else
			try {
				this.solicitudService.save(solicitud);
				result = new ModelAndView("redirect: listCRUD.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(solicitud, "solicitud.commit.error");
			}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final Solicitud solicitud, final String message) {
		ModelAndView result;

		result = new ModelAndView("solicitud/add");
		result.addObject("solicitud", solicitud);
		result.addObject("cursos", this.cursoService.findAll());
		result.addObject("alumno", this.alumnoService.findByPrincipal());
		result.addObject("message", message);

		return result;
	}

}
