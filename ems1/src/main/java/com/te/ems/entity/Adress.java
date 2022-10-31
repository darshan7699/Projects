package com.te.ems.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Adress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adressId;
	private int doorNo;
	private String city;
	private String street;
	private String buildingName;
	private String state;
	private int pincode;
	
	

}
