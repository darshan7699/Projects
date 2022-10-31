package com.te.ems;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.te.ems.controlleradviser.DataNotFoundexception;
import com.te.ems.controlleradviser.ListEmptyException;
import com.te.ems.dto.EmployeeDto;
import com.te.ems.entity.Employee;
import com.te.ems.repository.EmployeeRepo;
import com.te.ems.services.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	EmployeeServiceImpl impl;

	@Mock
	EmployeeRepo employeeRepo;

	@Test
	public void add() {
		Employee build = Employee.builder().age(20).lastName("Darshan").firstName("wawale").build();
		EmployeeDto build2 = EmployeeDto.builder().age(20).lastName("Darshan").firstName("wawale").build();
		when(employeeRepo.save(build)).thenReturn(build);
		Employee add = impl.add(build2);
		assertEquals(build, add);
	}

	@Test
	public void find() {
		Optional<Employee> build = Optional
				.of(Employee.builder().id(1).age(20).lastName("Darshan").firstName("wawale").build());
		when(employeeRepo.findById(Mockito.any())).thenReturn(build);
		Employee find = impl.find(1);
		assertEquals(build.get().getAge(), find.getAge());
	}

	@Test
	public void findelse() {
		DataNotFoundexception assertThrows2 = assertThrows(DataNotFoundexception.class, () -> impl.find(1010));
		assertEquals("Data Not Found", assertThrows2.getMessage());
	}

	@Test
	void delete() {
		Employee build = Employee.builder().age(20).id(1).lastName("Darshan").firstName("wawale").build();
		when(employeeRepo.findById(build.getId())).thenReturn(Optional.of(build));
		impl.delete(1);
		verify(employeeRepo).deleteById(build.getId());
	}

	@Test
	public void deleteCatch() {
		DataNotFoundexception assertThrows2 = assertThrows(DataNotFoundexception.class, () -> impl.delete(1010));
		assertEquals("Id Not Match", assertThrows2.getMessage());
	}

	@Test
	void findAll() {
		List<Employee> asList = Arrays.asList(Employee.builder().age(20).id(1).lastName("Darshan").firstName("wawale").build(),
				Employee.builder().age(20).id(2).lastName("Darshan").firstName("wawale").build());
		when(employeeRepo.findAll()).thenReturn(asList);
		List<Employee> findall = impl.findall();
		assertThat(asList.equals(findall));
	}
	
	@Test
	void findAllCatch() {
		ListEmptyException e = assertThrows(ListEmptyException.class, () -> impl.findall());
		assertThat(e.getMessage().equals("List Is Empty"));
		//assertThat(e.getMessage()).isEqualTo("Something Went Wrong");
	}
	
	@Test
	void update() {
		Employee build = Employee.builder().age(20).id(2).lastName("Darshan").firstName("wawale").build();
		EmployeeDto build1 = EmployeeDto.builder().age(20).lastName("Darshan").firstName("wawale").build();
		when(employeeRepo.findById(2)).thenReturn(Optional.of(build));
		when(employeeRepo.save(build)).thenReturn((build));
		Employee update = impl.update(2, build1);
		assertEquals(build.getAge(), update.getAge());
	}
	
	@Test
	void updateCatch() {
		Employee build = Employee.builder().age(20).id(2).lastName("Darshan").firstName("wawale").build();
		EmployeeDto build1 = EmployeeDto.builder().age(20).lastName("Darshan").firstName("wawale").build();
		//when(employeeRepo.findAllById(null)).thenThrow(RuntimeException.class);
		RuntimeException assertThrows2 = assertThrows(RuntimeException.class,() -> impl.update(1021, build1));
		//assertEquals("Id is not present",assertThrows2.getMessage());
		assertThat(assertThrows2.getMessage().equals("Id is not present"));
	}
	
	
}
