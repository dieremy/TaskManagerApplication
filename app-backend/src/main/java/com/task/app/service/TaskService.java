package com.task.app.service;

import com.task.app.model.Task;

import java.util.List;

public interface TaskService {

    void createTask(Task task);

    void updateTask(Long id, Task task);

    void deleteTask(Long id);

    List<Task> findAll();

    Task getTaskById(Long id);
}