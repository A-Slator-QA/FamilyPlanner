package com.qa.planner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.planner.model.Person;
import com.qa.planner.repo.PersonRepo;

@Service
public class PersonService {

	private Person person;

	@Autowired
	private PersonRepo repo;

	public PersonService(PersonRepo repo) {
		this.repo = repo;
		person = new Person();
	}

	public Person createPerson(Person person) {
		return repo.save(person);
	}

	public List<Person> readAllPeople() {
		return this.repo.findAll();
	}

	public Person readPerson(Long id) {
		return repo.findById(id).get();
	}

	public Person updatePerson(Person updatePerson, Long id) {
		Optional<Person> currentPerson = this.repo.findById(id);
		Person oldPerson = currentPerson.get();
		oldPerson.setName(updatePerson.getName());
		oldPerson.setAge(updatePerson.getAge());
		oldPerson.setParent(updatePerson.isParent());
		return repo.save(oldPerson);
	}

	public boolean deletePerson(Long id) {
		Optional<Person> currentPerson = this.repo.findById(id);
		boolean isPresent = (currentPerson.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
