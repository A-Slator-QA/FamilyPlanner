package com.qa.planner.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.planner.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

	@Query(value = "SELECT * from Task", nativeQuery = true)
	public List<Task> findAllTasks();

	@Query(value = "SELECT * from Task WHERE name = ?1", nativeQuery = true)
	List<Task> findTaskByNameSQL(String name);

}
