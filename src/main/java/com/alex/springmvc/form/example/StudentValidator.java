package com.alex.springmvc.form.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.equals(clazz);  
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", null, "name is empty.");
		Student student = new Student();
		if (null == student.getPassword() || "".equals(student.getPassword()))
			errors.rejectValue("password", null, "Password is empty.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "age", "required.age", "age is empty.");
	}

}
