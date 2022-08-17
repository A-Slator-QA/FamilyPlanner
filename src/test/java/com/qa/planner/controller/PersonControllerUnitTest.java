package com.qa.planner.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.planner.model.Person;
import com.qa.planner.service.PersonService;

@WebMvcTest
public class PersonControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private PersonService service;

	@Test
	public void createPerson_ValidPerson_Person() throws Exception {
		Person testPerson = new Person("Piers", 18, false);
		String testPersonAsJSON = this.mapper.writeValueAsString(testPerson);

		Mockito.when(this.service.createPerson(testPerson)).thenReturn(testPerson);

		mvc.perform(post("/home/createPerson").content(testPersonAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(content().json(testPersonAsJSON));
		Mockito.verify(this.service, Mockito.times(1)).createPerson(testPerson);
	}

	@Test
	public void readPerson_ValidPerson_ReadAll() throws Exception {

		List<Person> allPeople = Arrays.asList(
				new Person (1L, "Robert", 24, false),
				new Person (2L, "Kate", 22, false),
				new Person (3L, "Ian", 40, true)
				);


		Mockito.when(this.service.readAllPeople().thenReturn(allPeople));

		mvc.perform(get("/home/readPeople").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect((ResultMatcher) jsonPath("$[0].name"));
		Mockito.verify(this.service, Mockito.times(1)).readAllPeople();
	}

}
