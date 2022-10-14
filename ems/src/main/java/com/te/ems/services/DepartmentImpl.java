package com.te.ems.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ems.entity.Department;
import com.te.ems.repository.DepartmentRepo;

@Service
public class DepartmentImpl implements DepartmentInterface {
	
	@Autowired
	DepartmentRepo departmentRepo;

	@Override
	public Department add(Department department) {
		System.out.println(department);
         Department save = departmentRepo.save(department);
         System.out.println(save);
		return save;
	}

}
