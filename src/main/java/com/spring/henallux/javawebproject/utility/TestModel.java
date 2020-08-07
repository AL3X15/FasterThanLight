package com.spring.henallux.javawebproject.utility;


import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class TestModel<T> {
	private T objectToTest;

	public void setObjectToTest(T objectToTest) {
		this.objectToTest = objectToTest;
	}

	public boolean hasError() {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<T>> constraintViolations = validator.validate(objectToTest);

		return constraintViolations.size() > 0;
	}
}
