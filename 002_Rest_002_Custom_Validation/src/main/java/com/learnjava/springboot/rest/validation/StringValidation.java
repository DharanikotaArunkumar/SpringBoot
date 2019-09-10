package com.learnjava.springboot.rest.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StringValidator.class})
@Documented
public @interface StringValidation {
    String message()   default "{com.string.validator.message}"; 

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}