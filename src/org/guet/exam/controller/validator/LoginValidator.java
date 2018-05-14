package org.guet.exam.controller.validator;

import org.guet.exam.controller.command.LoginCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return LoginCommand.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		
	}

}
