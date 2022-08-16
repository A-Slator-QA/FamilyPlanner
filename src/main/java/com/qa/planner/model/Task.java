package com.qa.planner.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
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

	@ManyToOne(targetEntity = Person.class, fetch = FetchType.LAZY)
	private int assignee;

	public Task(Long taskId, String taskName) {
		this.taskId = taskId;
		this.taskName = taskName;
	}

	public Task(String taskName) {
		this.taskName = taskName;
	}

}
