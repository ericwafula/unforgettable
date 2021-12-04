package tech.ericwathome.unforgettable.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.ericwathome.unforgettable.task.Task;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @NotEmpty(message = "username cannot be empty ")
    private String username;
    @NotEmpty(message = "First Name cannot be empty ")
    private String firstName;
    @NotEmpty(message = "Last Name cannot be empty ")
    private String lastName;
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "user_tasks_task_id")
    private Task userTasks;
}
