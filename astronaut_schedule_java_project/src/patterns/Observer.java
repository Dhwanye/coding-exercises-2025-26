package patterns;

public interface Observer {
    void notifyConflict(Task task, Task conflictingTask);
}