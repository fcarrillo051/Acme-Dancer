
package controllers.alumno;

import javax.validation.Valid;

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

	//METODO GET DEL EDITAR TARJETA CREDITO
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;
		Alumno alumno;
		TarjetaCredito tar;

		alumno = this.alumnoService.findByPrincipal();
		tar = alumno.getTarjetaCredito();

		if (tar == null)
			tar = this.tarjetaService.create();

		result = this.createEditModelAndView(tar);

		return result;
	}

	//METODO POST DEL EDITAR O AGREGAR NUEVA TARJETA DE CREDITO
	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final TarjetaCredito tar, final BindingResult binding) {
		ModelAndView result;

		if (binding.hasErrors())
			result = this.createEditModelAndView(tar);
		else
			try {
				this.tarjetaService.save(tar);

				Alumno alumno = this.alumnoService.findByPrincipal();

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

	protected ModelAndView createEditModelAndView(final TarjetaCredito tar) {
		return this.createEditModelAndView(tar, null);
	}

	protected ModelAndView createEditModelAndView(final TarjetaCredito tar, final String message) {
		ModelAndView result;
		Alumno alumno;

		alumno = this.alumnoService.findByPrincipal();
		tar.setAlumno(alumno);

		System.out.println("Version " + tar.getVersion() + " Año Cad " + tar.getAnioCad() + " CVV " + tar.getCvv() + " Marca " + tar.getMesCad() + " Mes Cad " + tar.getMesCad() + " Nombre " + tar.getNombreTitular() + " Numero " + tar.getNumero()
			+ " Alumno " + tar.getAlumno());

		result = new ModelAndView("tarjeta/edit");
		result.addObject("tarjetaDeCredito", tar);
		result.addObject("alumno", alumno);
		result.addObject("message", message);

		return result;
	}

}
