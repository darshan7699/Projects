package com.te.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ems.controller.EmployeeController;
import com.te.ems.dto.EmployeeDto;
import com.te.ems.entity.Employee;
import com.te.ems.response.Response;
import com.te.ems.services.EmployeeService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class EmployeeControllerTest {

	@MockBean
	EmployeeService employeeInterface;

	@Autowired
	private WebApplicationContext context;

	private MockMvc mockMvc;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		this.objectMapper = new ObjectMapper();
	}

	@Test
	public void add() throws Exception {
		Employee build = Employee.builder().age(20).lastName("Darshan").firstName("wawale").build();
		EmployeeDto build2 = EmployeeDto.builder().age(20).lastName("Darshan").firstName("wawale").build();
		when(employeeInterface.add(Mockito.any())).thenReturn(build);
		String writeValueAsString = objectMapper.writeValueAsString(build2);
		String contentAsString = mockMvc 
				.perform(post("/addemployee").content(writeValueAsString).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Response readValue = objectMapper.readValue(contentAsString, Response.class);
		assertEquals(false, readValue.isError());
	}

	@Test
	public void find() throws UnsupportedEncodingException, Exception {
		Employee build = Employee.builder().age(20).id(1).lastName("Darshan").firstName("wawale").build();
		String writeValueAsString = objectMapper.writeValueAsString(build);
		when(employeeInterface.find(Mockito.anyInt())).thenReturn(build);
		String contentAsString = mockMvc.perform(get("/fetch").param("id", "1"))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
		Response readValue = objectMapper.readValue(contentAsString, Response.class);
		assertEquals(false, readValue.isError());
	}

	@Test
	public void findall() throws UnsupportedEncodingException, Exception {
		List<Employee> asList = Arrays.asList(
				Employee.builder().age(20).id(1).lastName("Darshan").firstName("wawale").build(),
				Employee.builder().age(20).id(1).lastName("Wawale").firstName("Darshan").build());
		String writeValueAsString = objectMapper.writeValueAsString(asList);
		Mockito.when(employeeInterface.findall()).thenReturn(asList);
		String contentAsString = mockMvc
				.perform(get("/findall").content(writeValueAsString).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Response readValue = objectMapper.readValue(contentAsString, Response.class);
		assertEquals(false, readValue.isError());

	}

	@Test
	public void delete() throws JsonProcessingException {
		Employee build = Employee.builder().age(20).id(1).lastName("Darshan").firstName("wawale").build();
		String writeValueAsString = objectMapper.writeValueAsString(build);
		doThrow(new InvalidParameterException()).when(employeeInterface).delete(10);
	}

	@Test
	public void update() throws UnsupportedEncodingException, Exception {
		Employee build = Employee.builder().age(20).id(1).lastName("Darshan").firstName("wawale").build();
		EmployeeDto build2 = EmployeeDto.builder().age(20).lastName("Darshan").firstName("wawale").build();
		String writeValueAsString = objectMapper.writeValueAsString(build);
		Mockito.when(employeeInterface.update(Mockito.anyInt(),Mockito.any())).thenReturn(build);
		String contentAsString = mockMvc
				.perform(put("/update/1").content(writeValueAsString).contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		Response readValue = objectMapper.readValue(contentAsString, Response.class);
		assertEquals(false, readValue.isError());
	}
}
