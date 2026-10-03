package com.gustavoloiola.taskmanager.domain;


import org.springframework.util.Assert;

import java.util.Optional;

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
}
