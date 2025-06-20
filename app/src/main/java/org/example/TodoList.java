package org.example;
import java.util.ArrayList;

public class TodoList {
    private ArrayList<String> incompleteList = new ArrayList<String>(); // Incomplete tasks
    private ArrayList<String> completedList = new ArrayList<String>();  // Completed tasks

    void add(String task) {
        incompleteList.add(task);
    }

    void complete(String task) {
        if (incompleteList.contains(task)) {
            incompleteList.remove(task);  
            completedList.add(task); // Move task to the completed list
            System.out.println("Task: '" + task + "' marked as completed.");
        } else {
            System.out.println("Task not found in the incomplete list.");
        }
    }

    void viewAll() {
        System.out.println("All Tasks:");
        System.out.println("Incomplete tasks:");
        for (int i = 0; i < incompleteList.size(); i++) {
            System.out.println((i + 1) + ". " + incompleteList.get(i));
        }
        System.out.println("\nCompleted tasks:");
        for (int i = 0; i < completedList.size(); i++) {
            System.out.println((i + 1) + ". " + completedList.get(i));
        }
        System.out.println();
    }

    void viewComplete() {
        System.out.println("Completed Tasks:");
        if (completedList.isEmpty()) {
            System.out.println("No tasks completed yet.");
        } else {
            for (int i = 0; i < completedList.size(); i++) {
                System.out.println((i + 1) + ". " + completedList.get(i));
            }
        }
        System.out.println();
    }

    void viewIncomplete() {
        System.out.println("Incomplete Tasks:");
        if (incompleteList.isEmpty()) {
            System.out.println("No tasks left to complete.");
        } else {
            for (int i = 0; i < incompleteList.size(); i++) {
                System.out.println((i + 1) + ". " + incompleteList.get(i));
            }
        }
        System.out.println();
    }

    void clear() {
        incompleteList.clear();
        completedList.clear();
        System.out.println("All tasks have been cleared.");
    }

    public int getIncompleteListSize() { // Used for access in App.java
        return incompleteList.size();
    }

    public int getCompletedListSize() {
        return completedList.size();
    }

    public String getCompletedTask(int index) {
        if (index >= 0 && index < completedList.size()) {
            return completedList.get(index);
        }
        return null;  
    }

    public String getIncompleteTask(int index) {
        if (index >= 0 && index < incompleteList.size()) {
            return incompleteList.get(index);
        }
        return null;  
    }
}
