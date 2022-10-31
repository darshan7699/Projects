package com.te.resumebuilder.entity;

import static com.te.resumebuilder.constants.ConstantResume.MAX_PERCENTAGE;
import static com.te.resumebuilder.constants.ConstantResume.MIN_PERCENTAGE;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.te.resumebuilder.util.ListToStringConvertor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationId;
	
	@NotEmpty
	private String highestEducation;
	
	@NotEmpty
	private String specialization;

	@NotEmpty
	@Convert(converter = ListToStringConvertor.class)
	private List<@NotBlank String> university;

	@NotNull
	@Range(min = 2000,max=2025)
	private int passOutYear;
	
	
	@DecimalMin(value ="35.00",message = MIN_PERCENTAGE)@DecimalMax(value = "100.00",message = MAX_PERCENTAGE)
	private double percentage;

}
