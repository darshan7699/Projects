package com.te.ems.pojo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.entity.Department;

public class DepartmentPojoTest {

	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}
	
	private String jsonString ="{\"deptName\":\"Devlopment\",\"deptNo\":10}";
	
	@Test
	void dept() throws JsonMappingException, JsonProcessingException {
		Department build = Department.builder().deptName("Devlopment").deptNo(10).build();
		Department readValue = mapper.readValue(jsonString, Department.class);
		assertThat(build.equals(readValue));
	}
}
