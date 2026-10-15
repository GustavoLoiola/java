package com.gustavoloiola.taskmanager.application;

import com.gustavoloiola.taskmanager.application.output.TaskOutput;
import com.gustavoloiola.taskmanager.domain.TaskId;
import com.gustavoloiola.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class GetTaskByIdUserCase {
    private final TaskRepository repository;

    public GetTaskByIdUserCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(TaskId id) {
        return repository.findById(id)
                .map(TaskOutput::from)
                .orElseThrow(()-> new TaskNotFoundException());
    }
}
