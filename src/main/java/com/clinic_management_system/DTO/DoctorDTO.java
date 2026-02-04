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
public class DoctorDTO {

	@Range(min = 101, message = "Please Enter Id Like 101.. ")
	private long id;

	@NotNull(message = "Enter Username Or Email ID")
	private String username;

	@Range(min = 6, message = "Please Enter password more than 6 digit")
	private String password;

	@Size(min = 5, max = 25, message = "Name should be  5 to 25 Character")
	private String name;

	@Size(min = 10, max = 10, message = "Number must contain 10 digits only")
	private String contact;

	@Size(min = 5, max = 25, message = "Specialites should not more than 25 digit less than 5")
	private String speciality;

	@NotNull(message = "Fees cant be zero")
	@Range(min = 10)
	private long fees;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public long getFees() {
		return fees;
	}

	public void setFees(long fees) {
		this.fees = fees;
	}

	public static Boolean validateDoctorDTO(DoctorDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<DoctorDTO>> violations = validator.validate(dto);
		for (ConstraintViolation<DoctorDTO> violation : violations) {
			System.out.println(violation.getMessage());
		}
		if (violations.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
