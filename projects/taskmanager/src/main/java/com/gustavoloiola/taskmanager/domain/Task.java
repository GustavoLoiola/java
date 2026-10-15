package com.gustavoloiola.taskmanager.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.Optional;

@Getter
@Setter
public class Task {
    private TaskId id;
    private String title;
    private Optional<String> description;
    private TaskStatus status;

    public Task(TaskId id, String title, Optional<String> description, TaskStatus status) {
        Assert.notNull(id, "O id não pode ser nulo!");

        this.id = id;
        this.title = title;
        this.description = description;
        this.status = TaskStatus.PENDING;
    }

    public Task(String title, String description) {
    }

    public void update(Optional<String> tittle,
                      Optional<String> description,
                      Optional<TaskStatus> status) {
        tittle.ifPresent(this::setTitle);
        description.ifPresent(d -> this.setDescription(Optional.of(d)));
        status.ifPresent(this::setStatus);
   }

}
