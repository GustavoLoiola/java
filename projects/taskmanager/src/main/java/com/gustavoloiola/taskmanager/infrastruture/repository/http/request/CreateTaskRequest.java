package com.gustavoloiola.taskmanager.infrastruture.repository.http.request;

import com.gustavoloiola.taskmanager.application.input.CreateTaskInput;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Optional;

public record CreateTaskRequest(
        @Size(min = 3, max = 100)
        @NotBlank
        String title,
        @Size(max = 500)
        Optional<String> description) {
    public CreateTaskInput toInput() {
        return new CreateTaskInput(title, description);
    }
}
