package com.qa.planner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long personId;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(nullable = false)
	private int age;

	@Column(nullable = false)
	private boolean parent;

<<<<<<< Updated upstream
	public Person(String name, int age, boolean parent) {
		this.name = name;
=======
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
>>>>>>> Stashed changes
		this.age = age;
		this.parent = parent;
	}

}
