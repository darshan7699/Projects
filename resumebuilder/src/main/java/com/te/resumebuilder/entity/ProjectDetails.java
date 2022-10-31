package com.te.resumebuilder.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

import com.te.resumebuilder.util.ListToStringConvertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDetails implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int projectId;
	
	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> frontendTechnologies;
	
	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> backendTechnologies;
	
	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> designPatterns;
		
	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> databaseUse;
	
	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> developmentTools;

	@NotEmpty
	private String duration;

	@Positive
	private int teamSize;

	@NotEmpty @Lob
	@Column(name  ="projectDescription")
	private String projectDescription;
    
	@NotEmpty @Lob
	@Column(name  ="rolesAndResponsibalities")
	private String rolesAndResponsibalities;

}
