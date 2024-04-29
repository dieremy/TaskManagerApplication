package com.task.app.controller;

import java.util.List;

import javax.validation.Valid;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.app.service.TaskService;

import lombok.RequiredArgsConstructor;

import com.task.app.model.Task;

@RestController
@RequestMapping("/api/tasks/v1")
@RequiredArgsConstructor
public class TaskController {
    
    private TaskService taskService;

    // @Autowired
    // public TaskController(TaskService taskService) {
    //     this.taskService = taskService;
    // }

    @GetMapping("/helloWorld") 
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("HELLO WORLD FROM FUCKING SPRING BOOT");
    }

    @GetMapping("/listTasks")
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @PostMapping("/createTask")
    public ResponseEntity<?> createTask(@Valid @RequestBody Task task, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        } else {
            taskService.createTask(task);
            return ResponseEntity.ok().build();
        }
    }
    
    @GetMapping("/deleteTask/{id}") 
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
