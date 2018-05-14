package org.guet.exam.controller.validator;

import org.guet.exam.controller.command.ArticleCommand;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ArticleValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		
		return   ArticleCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		
	}

}
