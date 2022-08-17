package com.qa.planner.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class PersonModelUnitTest {

	static Person testPerson;

	@BeforeAll
	public static void makePerson() {
		System.out.println("Making a Person");
		testPerson = new Person(1L, "Andrew", 27, false);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Person.class).verify();
	}

	@Test
	public void constructors_Person_Person() {
		Person personOne = new Person();
		assertTrue(personOne instanceof Person == true);

		Person personTwo = new Person("Kieran", 25, false);
		;
		assertTrue(personTwo instanceof Person == true);

		Person personThree = new Person(3L, "David", 28, true);
		assertTrue(personThree instanceof Person == true);
	}

	@Test
	public void toString_String_PersonInstance() {
		String expecting = "Person [personId=" + testPerson.getPersonId() + ", personName=" + testPerson.getPersonName()
				+ ", age=" + testPerson.getAge() + ", parent=" + testPerson.isParent() + "]";
		assertEquals(expecting, testPerson.toString());
	}

	@Test
	public void setIdTest() throws NoSuchFieldException, IllegalAccessException {
		Person testPerson = new Person(4L, "Richard", 29, false);
		testPerson.setPersonId(5L);

		Field expected = testPerson.getClass().getDeclaredField("personId");
		expected.setAccessible(true);
		assertEquals(expected.get(testPerson), 5L);
	}

	@Test
	public void setNameTest() throws NoSuchFieldException, IllegalAccessException {
		Person testPerson = new Person(4L, "Jack", 29, false);
		testPerson.setPersonName("Jill");

		Field expected = testPerson.getClass().getDeclaredField("personName");
		expected.setAccessible(true);
		assertEquals(expected.get(testPerson), "Jill");
	}

	@Test
	public void setAgeTest() throws NoSuchFieldException, IllegalAccessException {
		Person testPerson = new Person(4L, "Johnson", 24, true);
		testPerson.setAge(25);

		Field expected = testPerson.getClass().getDeclaredField("age");
		expected.setAccessible(true);
		assertEquals(expected.get(testPerson), 25);
	}

	@Test
	public void setParentTest() throws NoSuchFieldException, IllegalAccessException {
		Person testPerson = new Person(6L, "Emily", 27, false);
		testPerson.setParent(true);

		Field expected = testPerson.getClass().getDeclaredField("parent");
		expected.setAccessible(true);
		assertEquals(expected.get(testPerson), true);
	}

}
