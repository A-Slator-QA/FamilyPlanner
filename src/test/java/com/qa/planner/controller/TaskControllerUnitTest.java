package com.qa.planner.controller;

import org.mockito.Mockito;

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
		String testTaskAsJSON = this.mapper..writeValueAsString(testTask);
		
		Mockito.when(this.service.createTask(testTask)).thenReturn(testTask);
		
		mvc.perform(pos("/home/createTask").content(testTaskAsJSON).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated()).andExpect(content().json(testCatAsJSON));
		Mockito.verify(this.service, Mockito.times(1)).createCat(testCat);
	}

}
