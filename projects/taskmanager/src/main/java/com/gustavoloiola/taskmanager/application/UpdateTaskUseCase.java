package com.gustavoloiola.taskmanager.application;

import com.gustavoloiola.taskmanager.application.input.UpdateTaskInput;
import com.gustavoloiola.taskmanager.application.output.TaskOutput;
import com.gustavoloiola.taskmanager.domain.TaskId;
import com.gustavoloiola.taskmanager.domain.TaskNotFoundException;
import com.gustavoloiola.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class UpdateTaskUseCase {
    private final TaskRepository repository;

    public UpdateTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId taskId, UpdateTaskInput input) {
        var task = repository.findById(taskId).orElseThrow(()-> new TaskNotFoundException(taskId));
        task.update(input.tittle(), input.description(), input.status());
        var updated = repository.save(task);
        return TaskOutput.from(task);
    }
}
