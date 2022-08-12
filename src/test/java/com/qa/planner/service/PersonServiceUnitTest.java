package com.qa.planner.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.planner.model.Person;
import com.qa.planner.repo.PersonRepo;
import com.qa.planner.service.PersonService;

@SpringBootTest
public class PersonServiceUnitTest {

	@Autowired
	private PersonService service;

	@MockBean
	private PersonRepo repo;

	@Test
	public void createPerson_ValidPerson_Person() {
		Person savePerson = new Person("Anthony", 25, false);
		Person repoPerson = new Person(1L, "Anthony", 26, false);

		Mockito.when(this.service.createPerson(savePerson)).thenReturn(repoPerson);
		assertEquals(repoPerson, this.repo.save(savePerson));

		Mockito.verify(this.repo, Mockito.times(1)).save(savePerson);
	}

	@Test
	public void updatePerson_ValidId_UpdatePerson() {
		Long testId = 1L;
		Person updatePerson = new Person("Harry", 23, true);
		Optional<Person> mockOutputValid = Optional.ofNullable(new Person(1L, "Harry", 24, false));
		Person expectedOutput = new Person(1L, "Harry", 24, false);

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateTask(expectedOutput, 1L));
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

}
