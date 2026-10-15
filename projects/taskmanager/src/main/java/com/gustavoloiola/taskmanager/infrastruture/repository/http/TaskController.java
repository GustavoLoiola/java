package com.gustavoloiola.taskmanager.infrastruture.repository.http;

import com.gustavoloiola.taskmanager.application.CreateTaskUseCase;
import com.gustavoloiola.taskmanager.application.input.CreateTaskInput;
import org.springframework.web.bind.annotation.PostMapping;
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
    void create() {
       var input = new CreateTaskInput("Estudar", "2 horas de estudos");
       createTaskUseCase.execute(input);
    }
}
