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

import com.qa.planner.model.Task;
import com.qa.planner.service.TaskService;

@RestController
@RequestMapping("/task")
public class TaskController {

	@Autowired
	TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	@GetMapping("/get")
	public String showHOne() {
		return "<H1> Suh, dude!</H1>";

	}

	@PostMapping("/createTask")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		Task createTask = service.createTask(task);
		return new ResponseEntity<Task>(createTask, HttpStatus.CREATED);
	}

	@GetMapping("/getTasks")
	public ResponseEntity<List<Task>> getTasks() {
		List<Task> taskData = service.readAllTasks();
		return new ResponseEntity<List<Task>>(taskData, HttpStatus.OK);
	}

	@PutMapping("/assignTask/{id}")
	public ResponseEntity<Task> assignTask(@RequestBody Task task, @PathVariable Long id) {
		Task assignTask = service.assignTask(task, id);
		return new ResponseEntity<Task>(assignTask, HttpStatus.OK);
	}

	@PutMapping("/completeTask/{id}")
	public ResponseEntity<Task> completeTask(@RequestBody Task task, @PathVariable Long id) {
		Task completeTask = service.completeTask(task, id);
		return new ResponseEntity<Task>(completeTask, HttpStatus.OK);
	}

	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
		Boolean deletedTask = service.deleteTask(id);
		return (deletedTask) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}

}
