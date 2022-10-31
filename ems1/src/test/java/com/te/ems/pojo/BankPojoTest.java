package com.te.ems.pojo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.entity.Bank;

public class BankPojoTest {

	private ObjectMapper mapper;

	@BeforeEach
	public void setup() {
		this.mapper = new ObjectMapper();
	}
private String jsonString="{\"name\":\"CBI\",\"accountNo\":12000,\"ifsc\":\"CBIN028 \"}";

@Test
void bank() throws JsonMappingException, JsonProcessingException {
	Bank build = Bank.builder().name("CBI").accountNo(12000l).ifsc("CBIN028").build();
	Bank readValue = mapper.readValue(jsonString, Bank.class);
	assertThat(build.equals(readValue));
	
}
}
