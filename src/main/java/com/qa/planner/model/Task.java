package com.qa.planner.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;

	@Column(nullable = false)
	private String taskName;

	@Column(nullable = false)
	private boolean complete;

	@Column
	private Timestamp timeComplete;

	@Column(nullable = false, columnDefinition = "boolean default false")
	private boolean assigned;

	@Column
	private int assignee;

	public Task() {
	}

	public Task(String taskName) {
		this.taskName = taskName;
	}
}
