package com.gustavoloiola.taskmanager.domain;

public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(TaskId taskid) {
        super("Não foi possível encontrar uma task com o id " + taskid );
    }
}
