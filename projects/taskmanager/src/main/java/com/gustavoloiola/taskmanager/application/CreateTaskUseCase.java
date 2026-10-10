package com.gustavoloiola.taskmanager.application;

import com.gustavoloiola.taskmanager.application.input.CreateTaskInput;
import com.gustavoloiola.taskmanager.application.output.TaskOutput;
import com.gustavoloiola.taskmanager.domain.Task;
import com.gustavoloiola.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUseCase {
    private final TaskRepository repository;

    public CreateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(task);
    }
}
