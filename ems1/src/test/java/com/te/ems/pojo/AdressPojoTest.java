package com.te.ems.pojo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.entity.Adress;

public class AdressPojoTest {

	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}
	
	private String jsonString = "{\"adressId\": null,\"doorNo\": null,\"city\": \"Akole\" } " ;
        

	@Test
	void adress() throws JsonMappingException, JsonProcessingException {
		Adress build = Adress.builder().city("Akole").build();
		Adress readValue = mapper.readValue(jsonString,Adress.class);
		assertEquals(build.getCity(), readValue.getCity());
	}
}
