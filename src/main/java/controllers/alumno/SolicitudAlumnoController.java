
package controllers.alumno;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Solicitud;
import services.AlumnoService;
import services.SolicitudService;

@Controller
@RequestMapping("/solicitud/alumno")
public class SolicitudAlumnoController extends AbstractController {

	@Autowired
	private SolicitudService	solicitudService;
	@Autowired
	private AlumnoService		alumnoService;


	public SolicitudAlumnoController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Solicitud> solicitudes;
		Collection<Solicitud> solicitudesRegistradas;

		solicitudes = this.solicitudService.findAllActive();
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

}
