package com.clinic_management_system.DTO;

import java.util.Set;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class PatientDTO {

	@Range(min = 1001, message = "Please Enter Id Like 1001.. ")
	private long id;

	@Min(value = 18, message = "age should not be less than 18")
	@Max(value = 100, message = "age should not be more than 100")
	private int age;

	@Min(value = 30, message = "Wieght should not be less than 30")
	private long weight;

	@Size(min = 5, max = 25, message = "name should not be less than 5 and more than 25")
	private String name;

	@Pattern(regexp = "^[m&M|F&f]{1}$", message = "Must be M or F")
	private String gender;

	@Size(min = 10, max = 10, message = "Number must contain 10 digits only")
	private String contact;

	@Size(min = 5, max = 45, message = "Address should not be less than 5 and more than 45")
	private String address;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static Boolean validatePatientDTO(PatientDTO dto) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<PatientDTO>> violations = validator.validate(dto);
		for (ConstraintViolation<PatientDTO> violation : violations) {
			System.out.println(violation.getMessage());
		}
		if (violations.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}
}
