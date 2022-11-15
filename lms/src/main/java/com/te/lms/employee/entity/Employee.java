package com.te.lms.employee.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@JoinColumn(name = "employeeId")
	@OneToOne(cascade = CascadeType.ALL)
	private PrimaryInfo primaryInfo;
	
	@JoinColumn(name = "employeeId")
	@OneToOne(cascade = CascadeType.ALL)
	private SecondaryInfo secondaryInfo;
	
	@JoinColumn(name = "employeeId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<EducationDetails> educationDetails;
	
	
	@JoinColumn(name = "employeeId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Adress> adress;
	
	@JoinColumn(name = "employeeId")	
	@OneToOne(cascade = CascadeType.ALL)
	private Bank bank;
	
	@JoinColumn(name = "employeeId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Experience> experience;
	
	@JoinColumn(name = "employeeId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Technical> technical;
	
	@JoinColumn(name = "employeeId")
	@OneToMany(cascade = CascadeType.ALL)
	private List<Contact> contact;
}
