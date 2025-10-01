package patterns;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    public Task createTask(String desc, String start, String end, String priority) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            LocalTime startTime = LocalTime.parse(start, formatter);
            LocalTime endTime = LocalTime.parse(end, formatter);

            if (endTime.isBefore(startTime)) {
                throw new IllegalArgumentException("End time cannot be before start time.");
            }

            return new Task(desc, startTime, endTime, priority);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Use HH:mm");
        }
    }
}