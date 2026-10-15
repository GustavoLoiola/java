package com.gustavoloiola.taskmanager.application.input;

import com.gustavoloiola.taskmanager.domain.TaskStatus;

import java.util.Optional;

public record UpdateTaskInput(Optional<String> tittle,
                              Optional<String> description,
                              Optional<TaskStatus> status) {
}
