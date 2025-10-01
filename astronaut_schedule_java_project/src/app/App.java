package app;

import patterns.ScheduleManager;
import patterns.Task;
import patterns.TaskFactory;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduleManager manager = ScheduleManager.getInstance();
        TaskFactory factory = new TaskFactory();

        while (true) {
            System.out.println("\n--- Astronaut Daily Schedule Organizer ---");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> {
                    try {
                        System.out.print("Enter description: ");
                        String desc = scanner.nextLine();
                        System.out.print("Enter start time (HH:mm): ");
                        String start = scanner.nextLine();
                        System.out.print("Enter end time (HH:mm): ");
                        String end = scanner.nextLine();
                        System.out.print("Enter priority (High/Medium/Low): ");
                        String priority = scanner.nextLine();

                        Task task = factory.createTask(desc, start, end, priority);
                        manager.addTask(task);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 2 -> {
                    System.out.print("Enter description to remove: ");
                    String desc = scanner.nextLine();
                    manager.removeTask(desc);
                }
                case 3 -> manager.viewTasks();
                case 4 -> {
                    System.out.println("Exiting... Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}