
package controllers.alumno;

import javax.validation.Valid;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;
import domain.Alumno;
import domain.TarjetaCredito;
import services.AlumnoService;
import services.TarjetaCreditoServices;

@Controller
@RequestMapping("/tarjeta/alumno")
public class TarjetaAlumnoController extends AbstractController {

	@Autowired
	private AlumnoService			alumnoService;
	@Autowired
	private TarjetaCreditoServices	tarjetaService;


	// Constructor ---------------------------------------------------------------

	public TarjetaAlumnoController() {
		super();
	}

	// Creation ---------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;

		TarjetaCredito tar;

		tar = this.tarjetaService.create();
		result = this.createEditModelAndView(tar);

		return result;
	}

	//Edit ---------------------------------------------------------------------
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		Alumno alumno;
		TarjetaCredito tar;

		alumno = this.alumnoService.findByPrincipal();
		tar = alumno.getTarjetaCredito();

		if (tar == null) {
			result = new ModelAndView("redirect:create.do");
			return result;

		}
		Assert.assertNotNull(tar);
		result = this.createEditModelAndView(tar);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final TarjetaCredito tar, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())

			result = this.createEditModelAndView(tar);
		else
			try {
				this.tarjetaService.save(tar);
				result = new ModelAndView("redirect:/");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(tar, "tarjeta.commit.error");
			}

		return result;
	}

	// Ancillary methods ------------------------------------------------------

	protected ModelAndView createEditModelAndView(final TarjetaCredito tar) {
		ModelAndView result;

		result = this.createEditModelAndView(tar, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final TarjetaCredito tar, final String message) {
		ModelAndView result;

		Alumno alumno;

		alumno = this.alumnoService.findByPrincipal();
		tar.setAlumno(alumno);

		result = new ModelAndView("tarjeta/edit");
		result.addObject("tarjetaDeCredito", tar);
		result.addObject("alumno", alumno);
		result.addObject("message", message);

		return result;
	}

}
