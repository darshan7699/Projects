package com.te.ems.services;

import java.util.List;

import com.te.ems.dto.EmployeeDto;
import com.te.ems.entity.Employee;

public interface EmployeeService {

	Employee add(EmployeeDto dto);

	Employee find(int id);

	void delete(int id);

	List<Employee> findall();

	Employee update(int id, EmployeeDto dto);

}
