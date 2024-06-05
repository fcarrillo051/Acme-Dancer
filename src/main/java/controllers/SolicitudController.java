
package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.EstadoSolicitud;
import domain.Solicitud;
import services.SolicitudService;

@Controller
@RequestMapping("/solicitud")
public class SolicitudController extends AbstractController {

	@Autowired
	private SolicitudService solicitudService;


	// Constructors -----------------------------------------------------------

	public SolicitudController() {
		super();
	}

	// List alumn request ---------------------------------------------------------------

	@RequestMapping(value = "/list-alumn", method = RequestMethod.GET)
	public ModelAndView listAlumn() {
		ModelAndView result;
		Collection<Solicitud> solicitudes;

		solicitudes = this.solicitudService.findByAlumno();

		result = new ModelAndView("solicitud/list-alumn");
		result.addObject("requestURI", "solicitud/list-alumn.do");
		result.addObject("solicitudes", solicitudes);

		return result;
	}

	@RequestMapping(value = "/list-academy", method = RequestMethod.GET)
	public ModelAndView listAcademy() {
		ModelAndView result;
		Collection<Solicitud> solicitudes;

		solicitudes = this.solicitudService.findByAcademia();

		result = new ModelAndView("solicitud/list-academy");
		result.addObject("requestURI", "solicitud/list-academy.do");
		result.addObject("solicitudes", solicitudes);

		return result;
	}

	// Request ----------------------------------------------------------------

	@RequestMapping(value = "/aceptar", method = RequestMethod.POST)
	public ModelAndView aceptar(@RequestParam final int solicitudId) {
		ModelAndView result;
		Solicitud solicitud;
		solicitud = this.solicitudService.findOne(solicitudId);
		solicitud.setEstadoSolicitud(EstadoSolicitud.Aceptado);
		this.solicitudService.save(solicitud);
		result = new ModelAndView("redirect:/solicitud/list-academy.do");

		return result;
	}

	@RequestMapping(value = "/rechazar", method = RequestMethod.POST)
	public ModelAndView rechazar(@RequestParam final int solicitudId) {
		ModelAndView result;
		Solicitud solicitud;
		solicitud = this.solicitudService.findOne(solicitudId);
		solicitud.setEstadoSolicitud(EstadoSolicitud.Rechazado);
		this.solicitudService.save(solicitud);
		result = new ModelAndView("redirect:/solicitud/list-academy.do");

		return result;
	}

}
