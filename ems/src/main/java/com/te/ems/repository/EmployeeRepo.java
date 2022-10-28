package com.te.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ems.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Employee findByMail(String mail);
	
	public Employee findByPassword(String password);

}
