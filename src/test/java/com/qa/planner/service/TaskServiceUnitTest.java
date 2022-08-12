package com.qa.planner.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.planner.model.Task;
import com.qa.planner.repo.TaskRepo;

@SpringBootTest
public class TaskServiceUnitTest {

	@Autowired
	private TaskService service;

	@MockBean
	private TaskRepo repo;

	@Test
	public void createTask_ValidTask_Task() {
		Task saveTask = new Task("Take out bins");
		Task repoTask = new Task(1L, "Take out bins");

		Mockito.when(this.service.createTask(saveTask)).thenReturn(repoTask);
		assertEquals(repoTask, this.repo.save(saveTask));

		Mockito.verify(this.repo, Mockito.times(1)).save(saveTask);

	}

	@Test
	public void updateTask_ValidId_UpdateTask() {
		Long testId = 1L;
		Task updateTask = new Task("Make Bread");
		Optional<Task> mockOutputValid = Optional.ofNullable(new Task(1L, "Make Bed"));
		Task expectedOutput = new Task(1L, "Make Bed");

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateTask(expectedOutput, 1L));
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

	@Test
	public void completeTask_ValidId_CompleteTask() {
		Long testId = 1L;
		Task completeTask = new Task("Hoover");
		Optional<Task> mockOutputValid = Optional.ofNullable(new Task(1L, "Hoover", false, null, true, 1));
		Task expectedOutput = new Task(1L, "Hoover", false, null, true, 1);

		Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
		Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

		assertEquals(expectedOutput, this.service.updateTask(expectedOutput, 1L));
		Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
		Mockito.verify(this.repo, Mockito.times(1)).findById(testId);
	}

}
