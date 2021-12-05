package tech.ericwathome.unforgettable.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.ericwathome.unforgettable.user.User;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {
    @Autowired
    private TaskService taskService;

    private final Logger LOGGER = LoggerFactory.getLogger(TaskController.class);

    @PostMapping("/users/{id}/tasks/new")
    public Task addTask(@Valid @RequestBody Task task, @PathVariable("id") Long userId){
        LOGGER.info("addTask method in Task Controller");
        task.setUser(new User(userId, "", "", "", ""));
        return taskService.addTask(task, userId);
    }

    @GetMapping("/users/{id}/tasks")
    public List<Task> getUserTasks(@PathVariable("id") Long userId){
        return taskService.getUserTasks(userId);
    }

    @GetMapping("/users/{userId}/tasks/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") Long id){
        return taskService.getUserTask(id);
    }

    @GetMapping("/users/{userId}/tasks/task/{title}")
    public Task getTaskByTitle(@PathVariable("title") String title){
        return taskService.getUserTaskByTitle(title);
    }

    @PutMapping("/users/{userId}/tasks/{id}")
    public Task updateTask(@Valid @RequestBody Task task,
                           @PathVariable("id") Long taskId){
        return taskService.updateTask(task, taskId);
    }

    @DeleteMapping("/users/{userId}/tasks/{id}")
    public String deleteTask(@PathVariable("id") Long taskId){
        taskService.deleteTask(taskId);
        return "Task deleted successfully";
    }
}
