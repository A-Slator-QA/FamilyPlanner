package com.qa.planner.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;

	@Column(nullable = false)
	private String taskName;

	@Column(nullable = false)
	private boolean complete;

	@Column(nullable = false)
	private Timestamp timeComplete;
}
