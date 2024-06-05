
package controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Alumno;
import domain.TarjetaCredito;
import services.AlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController extends AbstractController {

	@Autowired
	private AlumnoService alumnoService;


	// Constructors -----------------------------------------------------------

	public AlumnoController() {
		super();
	}

	// Action-1 ---------------------------------------------------------------

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam(required = false) final boolean showError) {
		ModelAndView result;
		Alumno al = this.alumnoService.findByPrincipal();
		TarjetaCredito tar = al.getTarjetaCredito();

		result = new ModelAndView("alumno/edit");
		if (tar != null)
			result.addObject("tarjetaDeCredito", tar);
		else {
			TarjetaCredito t = new TarjetaCredito();
			result.addObject("tarjetaDeCredito", t);
		}
		result.addObject("alumno", al);
		result.addObject("showError", showError);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final TarjetaCredito tarjeta, final BindingResult binding) {
		ModelAndView result;
		Alumno al = this.alumnoService.findByPrincipal();
		System.out.println("entra");
		if (binding.hasErrors()) {
			System.out.println("tiene error");
			result = new ModelAndView("alumno/edit");
			result.addObject("tarjetaDeCredito", tarjeta);
			result.addObject("alumno", al);
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
				this.alumnoService.saveTarjeta(tarjeta);
				result = new ModelAndView("redirect:/");
			} catch (Exception e) {
				System.out.println("tiene error de guardado");
				System.out.println(e.getMessage());
				result = new ModelAndView("alumno/edit");
				result.addObject("tarjetaDeCredito", tarjeta);
				result.addObject("alumno", al);
				result.addObject("showError", true);
			}

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "edit")
	public ModelAndView edit(@Valid final TarjetaCredito tarjeta, final BindingResult binding) {
		ModelAndView result;
		Alumno al = this.alumnoService.findByPrincipal();
		System.out.println("entra");
		if (binding.hasErrors()) {
			System.out.println("tiene error");
			result = new ModelAndView("alumno/edit");
			result.addObject("tarjetaDeCredito", tarjeta);
			result.addObject("alumno", al);
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
				this.alumnoService.saveTarjeta(tarjeta);
				result = new ModelAndView("redirect:/");
			} catch (Exception e) {
				System.out.println("tiene error de guardado");
				System.out.println(e.getMessage());
				result = new ModelAndView("alumno/action-1");
				result.addObject("tarjetaDeCredito", tarjeta);
				result.addObject("alumno", al);
				result.addObject("showError", true);
			}

		return result;
	}
}
