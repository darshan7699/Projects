package com.te.lms.employee.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.te.lms.employee.entity.Adress;
import com.te.lms.employee.entity.Bank;
import com.te.lms.employee.entity.Contact;
import com.te.lms.employee.entity.EducationDetails;
import com.te.lms.employee.entity.Experience;
import com.te.lms.employee.entity.PrimaryInfo;
import com.te.lms.employee.entity.SecondaryInfo;
import com.te.lms.employee.entity.Technical;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

	private PrimaryInfo primaryInfo;

	private SecondaryInfo secondaryInfo;

	private List<EducationDetails> educationDetails;

	private List<Adress> adress;

	private Bank bank;

	private List<Experience> experience;

	private List<Technical> technical;

	private List<Contact> contact;

}
