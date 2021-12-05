package tech.ericwathome.unforgettable.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.ericwathome.unforgettable.user.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taskId;
    @NotEmpty(message = "A task needs to have a title")
    private String title;
    @NotEmpty(message = "A task needs to have a body")
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    public Task(Long taskId, String title, String body, Long userId) {
        this.taskId = taskId;
        this.title = title;
        this.body = body;
        this.user = new User(userId, "", "", "", "");
    }
}
