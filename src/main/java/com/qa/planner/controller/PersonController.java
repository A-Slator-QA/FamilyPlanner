package com.qa.planner.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.planner.model.Person;
import com.qa.planner.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService service;

	public PersonController(PersonService service) {
		this.service = service;
	}

	@GetMapping("/get")
	public String showHOne() {
		return "<H1> Oh I'm Strugglin! </H1>";
	}

	@PostMapping("/createPerson")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person createPerson = service.createPerson(person);
		return new ResponseEntity<Person>(createPerson, HttpStatus.CREATED);
	}

	@GetMapping("/getPeople")
	public ResponseEntity<List<Person>> getPeople() {
		List<Person> personData = service.readAllPeople();
		return new ResponseEntity<List<Person>>(personData, HttpStatus.OK);
	}

	@PutMapping("/updatePerson/{personId}")
	public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable Long personId) {
		Person updatePerson = service.updatePerson(person, personId);
		return new ResponseEntity<Person>(updatePerson, HttpStatus.OK);
	}

	@DeleteMapping("/deletePerson/{personId}")
	public ResponseEntity<Boolean> deletePerson(@PathVariable Long personId) {
		Boolean deletedPerson = service.deletePerson(personId);
		return (deletedPerson) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
