package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.te.resumebuilder.util.ListToStringConvertor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resume implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int profileId;

	private String resumeId;

	private String employeeId;

	private String firstName;

	private String lastName;

	private String email;

	private String mobileNo;

	@JsonFormat(pattern = "MM-dd-yyyy",lenient = OptBoolean.DEFAULT)
	private LocalDate dob;
	
	@JsonFormat(pattern = "MM-dd-yyyy",lenient = OptBoolean.DEFAULT)
	private LocalDate projectEndDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime abc;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private LocalDateTime timePattern;

	@Convert(converter = ListToStringConvertor.class)
	private List<String> technology;

	private String totalExperience;

	private String relevantExperience;

	@Convert(converter = ListToStringConvertor.class)
	private List<String> summary;

	@OneToOne(cascade = CascadeType.ALL)
	private TechnicalSkills skills;

	@OneToOne(cascade = CascadeType.ALL)
	private Education education;

	@JoinColumn(name = "profileId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<ProjectDetails> projectDetails;

}
