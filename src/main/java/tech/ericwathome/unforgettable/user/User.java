package tech.ericwathome.unforgettable.user;

import tech.ericwathome.unforgettable.task.Task;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class User {
    @Id
    private String userId;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    @ManyToOne
    @JoinColumn(name = "task_task_id")
    private Task task;

    public User(){}

    public User(String username, String firstName, String lastName, String email) {
        this.userId = username;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.task = new Task();
    }

    public String getId() {
        return userId;
    }

    public void setId(String id) {
        this.userId = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
