
package controllers.alumno;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	//METODO GET DEL EDITAR TARJETA CREDITO
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(required = false) final boolean showError) {
		ModelAndView result;
		Alumno alumno;
		TarjetaCredito tar;

		alumno = this.alumnoService.findByPrincipal();
		tar = alumno.getTarjetaCredito();

		if (tar == null)
			tar = this.tarjetaService.create();

		tar.setAlumno(alumno);
		result = new ModelAndView("tarjeta/edit");
		result.addObject("tarjetaDeCredito", tar);
		result.addObject("alumno", alumno);
		result.addObject("showError", showError);

		return result;
	}

	//METODO POST DEL EDITAR O AGREGAR NUEVA TARJETA DE CREDITO
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final TarjetaCredito tar, final BindingResult binding) {
		ModelAndView result;
		Alumno alumno;
		if (binding.hasErrors()) {
			alumno = this.alumnoService.findByPrincipal();
			result = new ModelAndView("tarjeta/edit");
			result.addObject("tarjetaDeCredito", tar);
			result.addObject("alumno", alumno);
			result.addObject("showError", true);
		} else
			try {
				this.tarjetaService.save(tar);

				alumno = this.alumnoService.findByPrincipal();

				//Si el Alumno no tiene Tarjeta, le añado la tarjeta nueva
				if (alumno.getTarjetaCredito() == null) {
					TarjetaCredito tar2 = this.tarjetaService.findByAlumno(alumno.getId());
					alumno.setTarjetaCredito(tar2);
					this.alumnoService.save(alumno);
				}

				result = new ModelAndView("redirect:/");

			} catch (Exception e) {
				System.out.println("tiene error de guardado");
				System.out.println(e.getMessage());
				result = new ModelAndView("tarjeta/edit");
				result.addObject("tarjetaDeCredito", tar);
				result.addObject("alumno", this.alumnoService.findByPrincipal());
			}

		return result;
	}
}
