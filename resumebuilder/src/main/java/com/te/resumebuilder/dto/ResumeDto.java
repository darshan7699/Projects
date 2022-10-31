package com.te.resumebuilder.dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;
import com.te.resumebuilder.entity.Education;
import com.te.resumebuilder.entity.ProjectDetails;
import com.te.resumebuilder.entity.TechnicalSkills;
import static com.te.resumebuilder.constants.ConstantResume.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

	

	

	private String employeeId;

	@NotNull
	@Pattern(regexp = FIRST_LAST_NAME, message = FIRSTNAME)
	private String firstName;

	@NotNull
	@Pattern(regexp = FIRST_LAST_NAME, message = LAST_NAME)
	private String lastName;

	@Email(message = EMAIL_IS_NOT_VALID, regexp = MAIL_VALIDATION)
	@NotNull
	private String email;

	@Pattern(regexp = MOBILE_VALIDATION, message = MOBILE_NUMBER)
	private String mobileNo;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy", lenient = OptBoolean.DEFAULT)
	@Past(message = PLEASE_ENTER_VALID_BIRTH_DATE)
	private LocalDate dob;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(pattern = "MM-dd-yyyy")
	@Future
	private LocalDate projectEndDate;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime abc;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime timePattern;

	@NotEmpty(message = TECHNOLOGIE)
	private List<@NotBlank String> technology;

	@NotEmpty
	private String totalExperience;

	@NotEmpty
	private String relevantExperience;

	@NotEmpty
	private List<@NotBlank String> summary;

	@Valid
	private TechnicalSkills skills;

	@Valid
	private Education education;

	@Valid
	private List<ProjectDetails> projectDetails;

}
