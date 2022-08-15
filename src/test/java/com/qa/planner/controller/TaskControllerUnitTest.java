package com.qa.planner.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.planner.model.Task;
import com.qa.planner.service.TaskService;

@WebMvcTest
public class TaskControllerUnitTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@MockBean
	private TaskService service;

	@Test
	public void createTask_ValidTask_Task() throws Exception {
		Task testTask = new Task("Read Book");
		String testTaskAsJSON = this.mapper.writeValueAsString(testTask);

		Mockito.when(this.service.createTask(testTask)).thenReturn(testTask);

		mvc.perform(post("/home/createTask").content(testTaskAsJSON).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andExpect(content().json(testTaskAsJSON));
		Mockito.verify(this.service, Mockito.times(1)).createTask(testTask);
	}

}
