package tech.ericwathome.unforgettable.task;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Time;
import java.util.Date;

@Entity
public class Task {
    @Id
    private String taskId;
    private String title;
    private String body;

    public Task(){}

    public Task(String taskId, String title, String body) {
        this.taskId = taskId;
        this.title = title;
        this.body = body;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
