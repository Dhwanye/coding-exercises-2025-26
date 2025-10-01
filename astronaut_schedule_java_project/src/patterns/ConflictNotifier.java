package patterns;

public class ConflictNotifier implements Observer {
    @Override
    public void notifyConflict(Task task, Task conflictingTask) {
        System.out.println("[NOTIFICATION] Conflict detected: " + task.getDescription() +
                " overlaps with " + conflictingTask.getDescription());
    }
}