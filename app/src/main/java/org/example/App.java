package org.example;
import java.util.Scanner; 

public class App {
  public static void main(String[] args) {
    TodoList todoList = new TodoList();
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to my To-Do List!");
    int choice = 0;
    String task; 
    while(choice != 7){ // Will get out of while loop when choice is 7
      System.out.println("Would you like to add a task(1), mark a task complete(2), view all tasks(3), " +
        "view completed tasks(4), view incompleted tasks(5), clear tasks(6), or exit(7)"); // Menu
        choice = sc.nextInt();
      if(choice == 1){
        System.out.println("What task would you like to add?");
        sc.nextLine();
        task = sc.nextLine(); 
        todoList.add(task);
        System.out.println(task + " was added to the To-Do List!");
      }
      else if (choice == 2) {
        System.out.println("Which task would you like to mark as completed?");
        todoList.viewIncomplete(); 
        System.out.println("Enter task number:");
        int taskNumber = sc.nextInt();
        sc.nextLine(); 
        if (taskNumber > 0 && taskNumber <= todoList.getIncompleteListSize()) {
          task = todoList.getIncompleteTask(taskNumber - 1);
          todoList.complete(task);
        } 
        else{
          System.out.println("Invalid task number.");
        }
        }
        else if (choice == 3) {
          todoList.viewAll();
         }
        else if (choice == 4) {
          todoList.viewComplete();
        }
        else if (choice == 5) {
          todoList.viewIncomplete();
        } 
        else if (choice == 6) {
          todoList.clear();
        } 
        else if (choice != 7) { // If choice is something other than these choices listed ex: 8 then it will spit out invalid.
          System.out.println("Invalid choice, please select a valid option.");
        }
      }

      sc.close(); 
      System.out.println("Thanks for running my To-Do List!");
  }
}
