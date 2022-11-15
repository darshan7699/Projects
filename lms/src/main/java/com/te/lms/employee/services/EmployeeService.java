package com.te.lms.employee.services;

import com.te.lms.employee.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto add(EmployeeDto employeeDto);

	EmployeeDto update(int employeeId, EmployeeDto employeeDto);
}
