package com.task.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.app.model.Task;
import com.task.app.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void createTask(Task task) {
        taskRepository.save(task);
    }
    
    @Override
    public void updateTask(Long id, Task newTask) {
        Task task = taskRepository.getReferenceById(id);
        task.setName(newTask.getName());    
        task.setDescription(newTask.getDescription());
        taskRepository.save(task);
    }
    
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
    
    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }
    
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
