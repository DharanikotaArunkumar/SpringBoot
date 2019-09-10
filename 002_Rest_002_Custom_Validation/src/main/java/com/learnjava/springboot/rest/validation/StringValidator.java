package com.learnjava.springboot.rest.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

public class StringValidator  implements ConstraintValidator<StringValidation, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		
		if (StringUtils.isNotBlank(value) && StringUtils.isAlpha(value)) {
			System.out.println("Validating string"+value);
			return true;
		}
        return false;
		
	}

}
