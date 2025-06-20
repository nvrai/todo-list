package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private TodoList todoList;

    @BeforeEach
    void setUp() {
        todoList = new TodoList();
    }

    @Test
    void testAddTask() {
        String task = "Complete Homework";
        todoList.add(task);

        assertEquals(1, todoList.getIncompleteListSize()); 
        assertEquals(task, todoList.getIncompleteTask(0));
    }

    @Test
    void testCompleteTask() {
        String task = "Complete Homework";
        todoList.add(task);
        todoList.complete(task);

        assertEquals(0, todoList.getIncompleteListSize()); // Making sure that the task moved
        assertEquals(1, todoList.getCompletedListSize());
        assertEquals(task, todoList.getCompletedTask(0));
    }

    @Test
    void testViewAllTasks() {
        todoList.add("Complete Homework");
        todoList.add("Buy Groceries");
        todoList.complete("Complete Homework");

        assertEquals(1, todoList.getIncompleteListSize()); // Checking the lists for correctness
        assertEquals(1, todoList.getCompletedListSize());
    }

    @Test
    void testViewCompleteTasks() {
        todoList.add("Complete Homework");
        todoList.add("Buy Groceries");
        todoList.complete("Complete Homework");

        // Check that the completed task is correctly shown
        todoList.viewComplete(); 
    }

    @Test
    void testViewIncompleteTasks() {
        todoList.add("Complete Homework");
        todoList.add("Buy Groceries");

        // Check that the incomplete tasks are correctly shown
        todoList.viewIncomplete(); 
    }

    @Test
    void testClearAllTasks() {
        todoList.add("Complete Homework");
        todoList.add("Buy Groceries");

        // Ensure that there are tasks before clearing
        assertEquals(2, todoList.getIncompleteListSize());

        // Clear all tasks and ensure both lists are empty
        todoList.clear();
        assertEquals(0, todoList.getIncompleteListSize());
        assertEquals(0, todoList.getCompletedListSize());
    }

    @Test
    void testCompleteTaskWithInvalidTask() { // Checking task that isnt there 
        String task = "Complete Homework"; 
        todoList.add("Buy Groceries");

        todoList.complete(task);  // Should print a message saying "Task not found"
    }

    @Test
    void testInvalidTaskNumberForCompletion() {
        todoList.add("Complete Homework");
    }
}
