package com.philiptenn.scholarship.validation;

import com.philiptenn.scholarship.model.Student;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class StudentValidator implements Validator {
	
	private final static String STUDENT_NUMBER = "studentNumber";

	@Override
	public boolean supports(Class<?> clazz) {
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		
		Integer studentNumber = student.getStudentNumber();
		
		ValidationUtils.rejectIfEmpty(errors, "firstName", "student.firstName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "student.lastName.empty");
		ValidationUtils.rejectIfEmpty(errors, STUDENT_NUMBER, "student.studentNumber.empty");
		
		if (studentNumber != null && studentNumber < 1)
			errors.rejectValue(STUDENT_NUMBER, "student.studentNumber.lessThenOne");

	}

}
