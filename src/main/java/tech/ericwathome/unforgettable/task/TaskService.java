package tech.ericwathome.unforgettable.task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(Task task, Long userId);

    List<Task> getUserTasks(Long userId);

    Optional<Task> getUserTask(Long id);

    Task getUserTaskByTitle(String title);

    Task updateTask(Task task, Long taskId);

    void deleteTask(Long taskId);
}
