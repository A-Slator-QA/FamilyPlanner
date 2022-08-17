package com.qa.planner.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.planner.model.Task;
import com.qa.planner.repo.TaskRepo;

@Service
public class TaskService {

	private Task task;

	@Autowired
	private TaskRepo repo;

	public TaskService(TaskRepo repo) {
		this.repo = repo;
		task = new Task();
	}

	public Task createTask(Task task) {
		return repo.save(task);
	}

	public List<Task> readAllTasks() {
		return this.repo.findAll();
	}

	public Task readTask(Long id) {
		return repo.findById(id).get();
	}

	public Task updateTask(Task updateTask, Long id) {
		Optional<Task> currentTask = this.repo.findById(id);
		Task oldTask = currentTask.get();
		oldTask.setTaskName(updateTask.getTaskName());
		return repo.save(oldTask);
	}

	public Task assignTask(Task assignTask, Long id) {
		Optional<Task> currentTask = this.repo.findById(id);
		Task oldTask = currentTask.get();
		oldTask.setAssignee(assignTask.getAssignee());
		return repo.save(oldTask);
	}

	public Task completeTask(Task completeTask, Long id) {
		Optional<Task> currentTask = this.repo.findById(id);
		Task oldTask = currentTask.get();
		oldTask.setComplete(true);
		return repo.save(oldTask);
	}

	public boolean deleteTask(Long id) {
		Optional<Task> currentTask = this.repo.findById(id);
		boolean isPresent = (currentTask.isPresent()) ? true : false;
		if (isPresent) {
			this.repo.deleteById(id);
			;
			return true;
		} else {
			return false;
		}
	}

}
