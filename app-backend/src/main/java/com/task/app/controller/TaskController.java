package com.task.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.app.service.TaskService;
import com.task.app.model.Task;

@RestController
@RequestMapping(value = "/api/tasks/v1", produces = "application/json")
public class TaskController {
    
    private TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("helloWorld") 
    public ResponseEntity<String> helloWorld() {
        return new ResponseEntity<>("HELLO WORLD FROM FUCKING SPRING BOOT", HttpStatus.OK);
    }

    @GetMapping("listTasks")
    public ResponseEntity<List<Task>> listTasks() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @PostMapping("createTask")
    public String createTask(@Valid Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "forms/task-new";
        } else {
            taskService.createTask(task);
            return "redirect:/tasks";
        }
    }
    
    @GetMapping("deleteTask/{id}") 
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
