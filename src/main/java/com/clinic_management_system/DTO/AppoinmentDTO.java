package com.clinic_management_system.DTO;

import java.util.Set;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Component
public class AppoinmentDTO {

	@Range(min = 1, message = "Please Enter Id Like 1.. ")
	private long Id;

	@Range(min = 1001, message = "Please Enter Id Like 1001.. ")
	private long patientId;

	@Range(min = 101, message = "Please Enter Id Like 101.. ")
	private long doctorId;

	@Size(min = 5, max = 25, message = "Name should be  5 to 25 Character")
	private String doctorName;

	@Size(min = 5, max = 25, message = "Name should be  5 to 25 Character")
	private String patientName;

	@NotNull
	private String problem;

	@DateTimeFormat
	private String date;

	@DateTimeFormat
	private String time;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getPatientId() {
		return patientId;
	}

	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public static boolean validateAppointmentDTO(AppoinmentDTO dto) {
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<AppoinmentDTO>> violations = validator.validate(dto);
		for (ConstraintViolation<AppoinmentDTO> violation : violations) {
			System.out.println(violation.getMessage());
		}
		if (violations.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}
