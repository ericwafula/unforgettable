package tech.ericwathome.unforgettable.task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    private Long taskId;
    @NotEmpty(message = "A task needs to have a title")
    private String title;
    @NotEmpty(message = "A task needs to have a body")
    private String body;
}
