package com.gustavoloiola.taskmanager.infrastruture.repository;

import com.gustavoloiola.taskmanager.domain.Task;
import com.gustavoloiola.taskmanager.domain.TaskId;
import com.gustavoloiola.taskmanager.domain.TaskRepository;

import java.util.List;
import java.util.Optional;

public class inMemoryTaskRepository implements TaskRepository {
    @Override
    public Task save(Task task) {
        return null;
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Optional<Task> findById(TaskId id) {
        return Optional.empty();
    }

    @Override
    public void delete(TaskId id) {

    }
}
