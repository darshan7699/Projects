package com.te.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.ems.dto.EmployeeDto;
import com.te.ems.entity.Employee;
import com.te.ems.jwthelper.JwtUtil;
import com.te.ems.response.Response;
import com.te.ems.services.EmployeeInterface;
import com.te.ems.wrapper.LogInWrapper;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeInterface employeeInterface;

	@Autowired 
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/addemployee")
	public ResponseEntity<Response> add(@RequestBody EmployeeDto dto) {
		return new ResponseEntity<>(new Response(false, "Data Succesfully Added", employeeInterface.add(dto)), HttpStatus.OK);
	}

	@GetMapping("/fetch")
	public ResponseEntity<Response> find(@RequestParam int id) {
		Employee find = employeeInterface.find(id);
		return new ResponseEntity<>(new Response(false, "Data Succesfully fetch", find), HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> delete(@RequestParam int id) {
		employeeInterface.delete(id);
		return new ResponseEntity<>(new Response(false, "Data Deleted Succesfully", null), HttpStatus.OK);
	}

	@GetMapping("/findall")
	public ResponseEntity<Response> findall() {
		List<Employee> findall = employeeInterface.findall();
		return new ResponseEntity<>(new Response(false, "All Details Of Employee", findall), HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Response> update(@PathVariable("id") int id, @RequestBody EmployeeDto dto) {
		Employee update = employeeInterface.update(id, dto);
		return new ResponseEntity<>(new Response(false, "Data Updated", update), HttpStatus.OK);
	}

	 @PostMapping("/authenticate")
	    public String generateToken(@RequestBody LogInWrapper authRequest) throws Exception {
	        try {
	            authenticationManager.authenticate(
	                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	            );
	        } catch (Exception ex) {
	            throw new Exception("inavalid username/password");
	        }
	        return jwtUtil.generateToken(authRequest.getUsername());
	    }

}
