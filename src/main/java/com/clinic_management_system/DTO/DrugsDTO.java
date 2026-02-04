package com.clinic_management_system.DTO;

import java.util.Set;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Size;

@Component
public class DrugsDTO {

	@Range(min = 2001, message = "Please Enter Id Like 2001.. ")
	private int id;

	@Size(min = 5, max = 25, message = "Name should be  5 to 25 Character")
	private String name;

	@Size(min = 5, max = 45, message = "Name should be  5 to 25 Character")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Boolean validateDrugsDTO(DrugsDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DrugsDTO>> violations = validator.validate(dto);
		for (ConstraintViolation<DrugsDTO> violation : violations) {
			System.out.println(violation.getMessage());
		}
		if (violations.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

}
