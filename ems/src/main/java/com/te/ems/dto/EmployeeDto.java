package com.te.ems.dto;

import java.util.List;

import com.te.ems.entity.Adress;
import com.te.ems.entity.Bank;
import com.te.ems.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDto {
	private String firstName;
	private String lastName;
	private String mail;
	private String password;
	private long phoneNo;
	private int age;
	private double sal;
	private double experience;

	private List<Adress> adress;

	private List<Bank> bank;

	private List<Department> department;

}
