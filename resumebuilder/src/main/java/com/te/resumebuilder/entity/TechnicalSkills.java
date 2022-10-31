package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.te.resumebuilder.util.ListToStringConvertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnicalSkills implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int techId;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> frontendTechnologies;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class) 
	private List<@NotBlank String> backendTechnologies;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> middlewareTechnologies;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> designPatterns;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> versionControlSystem;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> aws;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> sdlc;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> developmentTools;

}
