package tech.ericwathome.unforgettable.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.ericwathome.unforgettable.exceptions.TaskNotFoundException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task addTask(Task task, Long userId) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getUserTasks(Long userId) throws TaskNotFoundException {
        List<Task> tasksDB = taskRepository.findByUserUserId(userId);

        if (tasksDB.isEmpty()){
            throw new TaskNotFoundException("There are no tasks available");
        }
        return tasksDB;
    }

    @Override
    public Optional<Task> getUserTask(Long id) throws TaskNotFoundException {

        Optional<Task> taskDB = taskRepository.findById(id);

        if (taskDB.isEmpty()){
            throw new TaskNotFoundException("Task not found for the given id");
        }
        return taskDB;
    }

    @Override
    public Task getUserTaskByTitle(String title) {
        return taskRepository.findByTitle(title);
    }

    @Override
    public Task updateTask(Task task, Long taskId) {
        Task taskDB = taskRepository.findById(taskId).get();

        if(Objects.nonNull(task.getTitle()) &&
        !"".equalsIgnoreCase(task.getTitle())){
            taskDB.setTitle(task.getTitle());
        }

        if(Objects.nonNull(task.getBody()) &&
        !"".equalsIgnoreCase(task.getBody())){
            taskDB.setBody(task.getBody());
        }

        return taskRepository.save(taskDB);
    }

    @Override
    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }

}
