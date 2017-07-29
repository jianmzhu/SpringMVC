package com.alex.springmvc.form.example;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class FileUploadValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FileModel.class.equals(clazz);  
	}

	@Override
	public void validate(Object target, Errors errors) {
		FileModel fileModel = (FileModel)target;
		if(fileModel.getFile().isEmpty()){
			errors.rejectValue("file", null, "file is empty.");
		}
	}

}
