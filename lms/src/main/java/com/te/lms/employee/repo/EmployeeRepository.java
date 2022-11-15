package com.te.lms.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.lms.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
