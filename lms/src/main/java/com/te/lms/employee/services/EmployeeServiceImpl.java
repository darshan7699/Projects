package com.te.lms.employee.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.lms.customexception.IdNotFoundException;
import com.te.lms.employee.dto.EmployeeDto;
import com.te.lms.employee.entity.Employee;
import com.te.lms.employee.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public EmployeeDto add(EmployeeDto employeeDto) {
		Employee employee = Employee.builder().build();
		BeanUtils.copyProperties(employeeDto, employee);
		Employee save = employeeRepository.save(employee);
		EmployeeDto employeeDto2 = new EmployeeDto();
		BeanUtils.copyProperties(save, employeeDto2);
		return employeeDto2;
	}

	@Override
	public EmployeeDto update(int employeeId, EmployeeDto employeeDto) {
		try {
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IdNotFoundException("Id Not Found"));
		BeanUtils.copyProperties(employeeDto, employee);
		Employee save = employeeRepository.save(employee);
		EmployeeDto dto = new EmployeeDto();
		BeanUtils.copyProperties(save, dto);
		return dto;
		}catch (Exception e) {
			throw e;
		}
	}

	

}
