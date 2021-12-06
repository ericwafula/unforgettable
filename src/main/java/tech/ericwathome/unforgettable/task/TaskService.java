package tech.ericwathome.unforgettable.task;

import tech.ericwathome.unforgettable.exceptions.TaskNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(Task task, Long userId);

    List<Task> getUserTasks(Long userId) throws TaskNotFoundException;

    Optional<Task> getUserTask(Long id) throws TaskNotFoundException;

    Task getUserTaskByTitle(String title);

    Task updateTask(Task task, Long taskId);

    void deleteTask(Long taskId);
}
