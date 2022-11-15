package com.te.lms.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.lms.employee.dto.EmployeeDto;
import com.te.lms.employee.services.EmployeeService;
import com.te.lms.response.Response;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public ResponseEntity<Response> add(@RequestBody EmployeeDto employeeDto) {
		return new ResponseEntity<>(new Response(false, "Data Added Sucessfully", employeeService.add(employeeDto)),
				HttpStatus.OK);
	}
	
	@PutMapping("/employee_data/{employeeId}")
	public ResponseEntity<Response> update(@PathVariable int employeeId,@RequestBody EmployeeDto employeeDto) {
		 EmployeeDto update = employeeService.update(employeeId,employeeDto);
		return new ResponseEntity<>(new Response(false, "Data Added Sucessfully",update),
				HttpStatus.OK);
	}
}
