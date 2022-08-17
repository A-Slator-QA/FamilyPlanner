package com.qa.planner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;

	@Column(unique = true, nullable = false)
	private String personName;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private boolean parent;

	@OneToMany(mappedBy = "assignee", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Task> tasks;

	public Person(Long personId, String personName, int age, boolean parent) {
		this.personId = personId;
		this.personName = personName;
		this.age = age;
		this.parent = parent;
	}

	public Person(String personName, int age, boolean parent) {
		this.personName = personName;
		this.age = age;
		this.parent = parent;
	}

}
