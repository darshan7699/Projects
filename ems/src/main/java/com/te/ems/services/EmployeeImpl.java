package com.te.ems.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.te.ems.controlleradviser.DataNotFoundexception;
import com.te.ems.controlleradviser.ListEmptyException;
import com.te.ems.dto.EmployeeDto;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepo;

@Service
@Component
public class EmployeeImpl implements EmployeeInterface, UserDetailsService {

	@Autowired
	EmployeeRepo employeeRepo;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public Employee add(EmployeeDto dto) {
		try {
			Employee employee = Employee.builder().build();
			BeanUtils.copyProperties(dto, employee);
			/*employee.setPassword(encoder.encode(employee.getPassword()));
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setTo(employee.getMail());
			simpleMailMessage.setFrom("dsw7699@gmail.com");
			simpleMailMessage.setSubject("Registration Successfull!!");
			simpleMailMessage.setText("You Have Successfully Registered.\n Username :" + employee.getMail()
					+ "\n Password :" + employee.getPassword());
			javaMailSender.send(simpleMailMessage);*/
			return employeeRepo.save(employee);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Employee find(int id) {
		try {
			Optional<Employee> findById = employeeRepo.findById(id);
			if (findById.isPresent()) {
				return findById.get();
			}
			throw new DataNotFoundexception("Data Not Found");
		} catch (DataNotFoundexception e) {
			throw e;
		} catch (Exception e) {
			throw new DataNotFoundexception("Somthing Went Wrong");
		}
	}

	@Override
	public void delete(int id) {
		try {
			Optional<Employee> employee = employeeRepo.findById(id);
			if (employee.isPresent()) {
				employeeRepo.deleteById(id);
			} else {
				throw new DataNotFoundexception("Id Not Match");
			}
		} catch (DataNotFoundexception e) {
			throw e;
		} catch (Exception e) {
			throw new DataNotFoundexception("Somthing Went Wrong");
		}
	}

	@Override
	public List<Employee> findall() {
		try {
			List<Employee> findAll = employeeRepo.findAll();
			if (findAll == null) {
				throw new ListEmptyException("List Is Empty");
			} else {
				return findAll;
			}
		} catch (ListEmptyException e) {
			throw e;
		} catch (Exception e) {
			throw new ListEmptyException("Something Went Wrong");
		}
	}

	@Override
	public Employee update(int id, EmployeeDto dto) {
		try {
			Optional<Employee> findById = employeeRepo.findById(id);
			Employee employee2 = findById.get();
			if (findById.isPresent()) {
				BeanUtils.copyProperties(dto, employee2);
				employeeRepo.save(employee2);
				return employee2;
			} else {
				throw new RuntimeException("Id is not present");
			}
		} catch (DataNotFoundexception e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee user = employeeRepo.findByMail(username);
		return new User(user.getMail(), user.getPassword(), new ArrayList<>());
	}

}
