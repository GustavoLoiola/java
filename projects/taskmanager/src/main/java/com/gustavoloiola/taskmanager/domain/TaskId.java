package com.gustavoloiola.taskmanager.domain;

import java.util.UUID;

import org.springframework.util.Assert;

public record TaskId(UUID id) {
    public TaskId {
        Assert.notNull(id, "O id não pode ser nulo!");
    }

    public TaskId() {
        this(UUID.randomUUID());
    }

}
