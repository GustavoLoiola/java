package com.gustavoloiola.taskmanager.infrastruture.repository.http;

import com.gustavoloiola.taskmanager.application.CreateTaskUseCase;
import com.gustavoloiola.taskmanager.infrastruture.repository.http.request.CreateTaskRequest;
import com.gustavoloiola.taskmanager.infrastruture.repository.http.response.TaskResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    TaskResponse create(@RequestBody CreateTaskRequest request) {
       var input = request.toInput();
       var output = createTaskUseCase.execute(input);
       return TaskResponse.from(output);
    }
}
