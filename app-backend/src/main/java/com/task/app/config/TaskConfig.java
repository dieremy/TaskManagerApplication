package com.task.app.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.task.app.model.Task;

@Configuration
public class TaskConfig {
    
    @Bean
    CommandLineRunner commandLineRunner() {
       return args -> {
        Task task1 = new Task("the first task", "this is a beautiful task");
        Task task2 = new Task("the second task", "this is a shitty task");

        System.out.printf("1^ TASK name: %s\tdescription: %s", task1.getName(), task1.getDescription());
        System.out.printf("2^ TASK name: %s\tdescription: %s", task2.getName(), task2.getDescription());   
    }; 
    }
}
