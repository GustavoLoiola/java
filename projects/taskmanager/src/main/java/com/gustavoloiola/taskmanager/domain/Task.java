package com.gustavoloiola.taskmanager.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.util.Assert;

import java.util.Optional;

@Getter
@Setter
public class Task {
    private TaskId id;
    private String titte;
    private Optional<String> description;
    private TaskStatus status;

    public Task(TaskId id, String titte, Optional<String> description, TaskStatus status) {
        Assert.notNull(id, "O id não pode ser nulo!");

        this.id = id;
        this.titte = titte;
        this.description = description;
        this.status = TaskStatus.PENDING;
    }

   public void update(Optional<String> tittle,
                      Optional<String> description,
                      Optional<TaskStatus> status) {
        tittle.ifPresent(this::setTitte);
        description.ifPresent(d -> this.setDescription(Optional.of(d)));
        status.ifPresent(this::setStatus);
   }

}
