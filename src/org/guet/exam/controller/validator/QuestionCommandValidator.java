package org.guet.exam.controller.validator;

import org.guet.exam.controller.command.QuestionCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class QuestionCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return QuestionCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
