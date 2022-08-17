package com.qa.planner.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.planner.model.Person;
import com.qa.planner.repo.PersonRepo;

@SpringBootTest
public class PersonServiceUnitTest {

	@Autowired
	private PersonService service;

	@MockBean
	private PersonRepo repo;

	@Test
	public void createPerson_ValidPerson_Person() {
		Person savePerson = new Person("Anthony", 26, false);
		Person repoPerson = new Person(1L, "Anthony", 26, false);

		Mockito.when(this.service.createPerson(savePerson)).thenReturn(repoPerson);
		assertEquals(repoPerson, this.repo.save(savePerson));

		Mockito.verify(this.repo, Mockito.times(1)).save(savePerson);
	}

	@Test
	public void readPerson_ReadAll() {
		List<Person> people = new ArrayList();
		people.add(new Person(1L, "Simone", 28, false));

//		Mockito.when(this.service.readAllPeople()).thenReturn(people);
//		assertEquals(people, this.repo.findAllPeople());
//
//		Mockito.verify(this.repo, Mockito.times(1)).findAll();

		Mockito.when(this.service.readAllPeople()).thenReturn(people);
		assertEquals(people, this.service.readAllPeople());
		Mockito.verify(this.repo, Mockito.times(1)).findAll();

	}

	@Test
	public void readPerson_ValidId_ReadOne() {
		Long testId = 1L;
		Person readPerson = new Person("James", 42, true);
		Optional<Person> mockOutputValid = Optional.ofNullable(new Person(1L, "James", 42, true));
		Person expectedOutput = new Person(1L, "James", 42, true);

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		assertEquals(expectedOutput, this.service.readPerson(testId));

		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

	@Test
	public void updatePerson_ValidId_UpdatePerson() {
		Long testId = 1L;
		Person updatePerson = new Person("Harry", 23, true);
		Optional<Person> mockOutputValid = Optional.ofNullable(new Person(1L, "Harry", 24, false));
		Person expectedOutput = new Person(1L, "Harry", 24, false);

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updatePerson(expectedOutput, 1L));
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

//	@Test
//	public void deletePerson_ValidId_DeletePerson() {
//		Long testId = 1L;
//		Person deletePerson = new Person("Dan", 25, false);
//		Optional<Person> mockOutputValid = Optional.ofNullable(new Person(1L, "Dan", 25, false));
//	}
	@Test
	public void deletePerson_ValidPerson_DeletePerson() {
		Person deletePerson = new Person(1L, "Dan", 25, false);

		Mockito.when(this.repo.findById(deletePerson.getPersonId())).thenReturn(Optional.of(deletePerson));
		this.service.deletePerson(deletePerson.getPersonId());
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(deletePerson.getPersonId());
	}

	@Test
	public void deletePerson_InvalidPerson_DeletePerson() {
		Person testPerson = new Person(1L, "Dan", 25, false);
		Long testId = 2L;

		Mockito.when(this.repo.findById(2L)).thenReturn(Optional.of(testPerson));
		this.service.deletePerson(2L);
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(2L);
	}

}
