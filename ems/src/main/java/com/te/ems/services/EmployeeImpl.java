package com.te.ems.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.controlleradviser.DataNotFoundexception;
import com.te.ems.controlleradviser.ListEmptyException;
import com.te.ems.dto.EmployeeDto;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepo;

@Service
public class EmployeeImpl implements EmployeeInterface {

	@Autowired
	EmployeeRepo employeeRepo;

	@Override
	public Employee add(EmployeeDto dto) {
		try {
			Employee employee = Employee.builder().build();
			BeanUtils.copyProperties(dto, employee);
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

}
