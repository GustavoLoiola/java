package com.gustavoloiola.taskmanager.infrastruture.repository.http.request;

import com.gustavoloiola.taskmanager.application.input.CreateTaskInput;

import java.util.Optional;

public record CreateTaskRequest(String title, Optional<String> description) {
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }
}
