package com.te.ems.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Employee.EmployeeBuilder;

public class EmployeePojoTest {
	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}

	private String jsonString = "{\"firstName\":\"Darshan\",\"lastName\":\"wawale\" }";

	@Test
	void employeeTest() throws JsonMappingException, JsonProcessingException {
		Employee build = Employee.builder().firstName("Darshan").lastName("wawale").build();
		Employee readValue = mapper.readValue(jsonString, Employee.class);
		assertEquals(build, readValue);
	}
}
