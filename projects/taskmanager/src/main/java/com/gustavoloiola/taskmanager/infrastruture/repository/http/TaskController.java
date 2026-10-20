package com.gustavoloiola.taskmanager.infrastruture.repository.http;

import com.gustavoloiola.taskmanager.application.*;
import com.gustavoloiola.taskmanager.domain.TaskId;
import com.gustavoloiola.taskmanager.infrastruture.repository.http.request.CreateTaskRequest;
import com.gustavoloiola.taskmanager.infrastruture.repository.http.request.UpdateTaskRequest;
import com.gustavoloiola.taskmanager.infrastruture.repository.http.response.TaskResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetTaskUseCase getTaskUserCase;
    private final GetTaskByIdUseCase getTaskByIdUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetTaskUseCase getTaskUserCase, GetTaskByIdUseCase getTaskByIdUseCase, DeleteTaskUseCase deleteTaskUseCase, UpdateTaskUseCase updateTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getTaskUserCase = getTaskUserCase;
        this.getTaskByIdUseCase = getTaskByIdUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody @Valid CreateTaskRequest request) {
       var input = request.toInput();
       var output = createTaskUseCase.execute(input);
       return TaskResponse.from(output);
    }

    @GetMapping
    List<TaskResponse> list() {
        return getTaskUserCase.execute().stream().map(TaskResponse::from).toList();
    }

    @GetMapping("/{id}")
    TaskResponse read(@PathVariable String id) {
      var output = getTaskByIdUseCase.execute(new TaskId());
      return TaskResponse.from(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable UUID id) {
        deleteTaskUseCase.execute(new TaskId(id));
    }

    @PatchMapping("/{id}")
    TaskResponse update(@PathVariable UUID id, @RequestBody UpdateTaskRequest request) {
        var input = request.toInput();
        var output = updateTaskUseCase.execute(new TaskId(id), input);
        return TaskResponse.from(output);
    }
}
