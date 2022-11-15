package com.te.lms.employee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrimaryInfo implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int primaryInfoId;
	
	private String name;
	
	private String dateOfJioning;
	
	private String dob;
	
	private String email;
	
	private String bloodGroup;
	
	private String designation;
	
	private String gender;
	
	private String nationality;
	
	private String employeeStatus;
	
}
