package com.te.lms.employee.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor@NoArgsConstructor
@Data
@Builder
public class Adress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adressId;
	
	private String adressType;
	
	private int doorNo;
	
	private String street;
	
	private String locality;
	
	private String city;
	
	private String state;
	
	private int pinCode;
	
	private String landmark;
	

}
