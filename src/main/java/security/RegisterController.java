/*
 * LoginController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

@Controller
@RequestMapping("/security")
public class RegisterController extends AbstractController {

	// Supporting services ----------------------------------------------------

	@Autowired
	RegisterService service;


	// Constructors -----------------------------------------------------------

	public RegisterController() {
		super();
	}

	// Register ------------------------------------------------------------------

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@Valid final CredentialsRegister credentials, final BindingResult bindingResult, @RequestParam(required = false) final boolean showError) {
		Assert.notNull(credentials);
		Assert.notNull(bindingResult);

		ModelAndView result;

		result = new ModelAndView("security/register");
		result.addObject("credentials", credentials);
		result.addObject("showError", showError);

		return result;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView save(@Valid final CredentialsRegister credentials, final BindingResult binding, @RequestParam(required = false) final boolean showError) {
		ModelAndView result;
		System.out.println("entra");
		if (binding.hasErrors()) {
			System.out.println("tiene error");
			result = new ModelAndView("security/register");
			result.addObject("credentials", credentials);
			result.addObject("showError", true);
			// Imprimir errores en la consola
			for (ObjectError error : binding.getAllErrors()) {
				if (error instanceof FieldError) {
					FieldError fieldError = (FieldError) error;
					System.out.println("Field error in object '" + fieldError.getObjectName() + "' on field '" + fieldError.getField() + "': " + fieldError.getDefaultMessage());
				} else {
					System.out.println("Error in object '" + error.getObjectName() + "': " + error.getDefaultMessage());
				}
			}
		} else {
			try {
				this.service.save(credentials);
				result = new ModelAndView("redirect:/security/login.do");
			} catch (Exception e) {
				System.out.println("tiene error de guardado");
				e.printStackTrace();
				result = new ModelAndView("security/register");
				result.addObject("credentials", credentials);
				result.addObject("showError", true);
			}
		}

		return result;
	}

	// LoginFailure -----------------------------------------------------------

	@RequestMapping("/registerFailure")
	public ModelAndView failure() {
		ModelAndView result;

		result = new ModelAndView("redirect:login.do?showError=true");

		return result;
	}

}
