package com.gustavoloiola.taskmanager.application;

import com.gustavoloiola.taskmanager.application.output.TaskOutput;
import com.gustavoloiola.taskmanager.domain.TaskId;
import com.gustavoloiola.taskmanager.domain.TaskNotFoundException;
import com.gustavoloiola.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUseCase {
    private final TaskRepository repository;

    public GetTaskByIdUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id)
                .map(TaskOutput::from)
                .orElseThrow(()-> new TaskNotFoundException(id));
    }
}
