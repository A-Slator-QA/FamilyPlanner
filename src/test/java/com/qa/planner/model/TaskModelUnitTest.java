package com.qa.planner.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class TaskModelUnitTest {

	static Task testTask;

	@BeforeAll
	public static void makeTask() {
		System.out.println("Making a Task");
		testTask = new Task(1L, "Cook", false, false);
	}

	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Task.class).verify();
	}

	@Test
	public void constructors_Task_Task() {
		Task taskOne = new Task();
		assertTrue(taskOne instanceof Task == true);

		Task taskTwo = new Task("Get dressed");
		assertTrue(taskTwo instanceof Task == true);

		Task taskThree = new Task(3L, "Cool Task", false, true, 1);
		assertTrue(taskThree instanceof Task == true);
	}

	@Test
	public void toString_String_TaskInstance() {
		String expecting = "Task [taskId=" + testTask.getTaskId() + ", taskName=" + testTask.getTaskName()
				+ ", complete=" + testTask.isComplete() + ", assigned=" + testTask.isAssigned() + ", assignee="
				+ testTask.getAssignee() + "]";
		assertEquals(expecting, testTask.toString());
	}

	@Test
	public void setIdTest() throws NoSuchFieldException, IllegalAccessException {
		Task testTask = new Task(4L, "AnotherTask", false, false);
		testTask.setTaskId(5L);

		Field expected = testTask.getClass().getDeclaredField("taskId");
		expected.setAccessible(true);
		assertEquals(expected.get(testTask), 5L);
	}

	@Test
	public void setNameTest() throws NoSuchFieldException, IllegalAccessException {
		Task testTask = new Task(4L, "Tisk", false, false);
		testTask.setTaskName("Tosk");

		Field expected = testTask.getClass().getDeclaredField("taskName");
		expected.setAccessible(true);
		assertEquals(expected.get(testTask), "Tosk");
	}

	@Test
	public void setCompleteTest() throws NoSuchFieldException, IllegalAccessException {
		Task testTask = new Task(4L, "Something", false, true);
		testTask.setComplete(true);

		Field expected = testTask.getClass().getDeclaredField("complete");
		expected.setAccessible(true);
		assertEquals(expected.get(testTask), true);
	}

	@Test
	public void setAssignedTest() throws NoSuchFieldException, IllegalAccessException {
		Task testTask = new Task(6L, "Taskables", false, false);
		testTask.setAssigned(true);

		Field expected = testTask.getClass().getDeclaredField("assigned");
		expected.setAccessible(true);
		assertEquals(expected.get(testTask), true);
	}

	@Test
	public void setAssigneeTets() throws NoSuchFieldException, IllegalAccessException {
		Task testTask = new Task(7L, "ContrivedTask", false, false);
		testTask.setAssignee(1);

		Field expected = testTask.getClass().getDeclaredField("assignee");
		expected.setAccessible(true);
		assertEquals(expected.get(testTask), 1);
	}

}
