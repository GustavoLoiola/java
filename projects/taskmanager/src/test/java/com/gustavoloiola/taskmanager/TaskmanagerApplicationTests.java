package com.gustavoloiola.taskmanager;


import com.gustavoloiola.taskmanager.application.CreateTaskUseCase;
import com.gustavoloiola.taskmanager.application.input.CreateTaskInput;
import com.gustavoloiola.taskmanager.application.output.TaskOutput;
import com.gustavoloiola.taskmanager.domain.Task;
import com.gustavoloiola.taskmanager.domain.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateTaskUseCaseTest {

    @Mock
    private TaskRepository repository;

    @InjectMocks
    private CreateTaskUseCase useCase;

    @Test
    void deveCriarTarefaERetornarOutput() {
        // Arrange: preparamos os dados
        var input = new CreateTaskInput(
                "Estudar Spring Test",
                Optional.of("Aprender testes unitários")
        );

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // Act: executamos o caso de uso
        TaskOutput output = useCase.execute(input);

        // Assert: verificamos o resultado
        assertEquals("Estudar Spring Test", output.title());
        assertEquals(
                "Aprender testes unitários",
                output.description().orElseThrow()
        );

        // Verificamos se a tarefa foi salva
        verify(repository).save(any(Task.class));
    }
}

