package patterns;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScheduleManager {
    private static ScheduleManager instance;
    private final List<Task> tasks = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    private ScheduleManager() {}

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(Observer observer) { observers.add(observer); }

    public void addTask(Task task) {
        for (Task t : tasks) {
            if (t.getStartTime().isBefore(task.getEndTime()) && task.getStartTime().isBefore(t.getEndTime())) {
                notifyObservers(task, t);
                System.out.println(String.format("Error: Task conflicts with existing task \"%s\".", t.getDescription()));


                return;
            }
        }
        tasks.add(task);
        tasks.sort(Comparator.comparing(Task::getStartTime));
        System.out.println("Task added successfully. No conflicts.");
    }

    public void removeTask(String desc) {
        Task toRemove = tasks.stream().filter(t -> t.getDescription().equalsIgnoreCase(desc)).findFirst().orElse(null);
        if (toRemove != null) {
            tasks.remove(toRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
            return;
        }
        for (Task t : tasks) {
            System.out.println(t);
        }
    }

    private void notifyObservers(Task newTask, Task existingTask) {
        for (Observer o : observers) {
            o.notifyConflict(newTask, existingTask);
        }
    }
}