package com.gustavoloiola.taskmanager.infrastruture.repository.http.request;

import com.gustavoloiola.taskmanager.application.input.UpdateTaskInput;
import com.gustavoloiola.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskRequest(Optional<String> title,
                                Optional<String> description,
                                Optional<String> status) {
    UpdateTaskInput toInput() {
        return new UpdateTaskInput(title, description, status.map(TaskStatus::valueOf));
    }
}
