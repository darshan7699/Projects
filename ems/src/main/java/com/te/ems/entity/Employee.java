package com.te.ems.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	private String mail;
	private long phoneNo;
	private int age;
	private double sal;
	private double experience;

	@JoinColumn(name = "id")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Adress> adress;

	

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private List<Bank> bank;
	
	@JoinColumn(name = "id")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Department>department;
	
	

}
