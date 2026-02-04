package com.clinic_management_system.DTO;

import java.util.Set;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class LabTestDTO {

	@Range(min = 1001, message = "Please Enter Id Like 1001.. ")
	private long id;

	@NotNull
	private long price;

	@Size(min = 5, max = 25, message = "Name should be  5 to 25 Character")
	@NotNull
	private String name;

	private long PatientId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPatientId() {
		return PatientId;
	}

	public void setPatientId(long patientId) {
		PatientId = patientId;
	}

	public static Boolean validateLabTestDTO(LabTestDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<LabTestDTO>> violations = validator.validate(dto);
		for (ConstraintViolation<LabTestDTO> violation : violations) {
			System.out.println(violation.getMessage());
		}
		if (violations.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
