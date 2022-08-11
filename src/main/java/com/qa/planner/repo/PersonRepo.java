package com.qa.planner.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.planner.model.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person, Long> {

	@Query(value = "SELECT * from Person", nativeQuery = true)
	public List<Person> findAllPeople();

	@Query(value = "SELECT * from Person WHERE name = ?1", nativeQuery = true)
	List<Person> findPersonByNameSQL(String name);
}
