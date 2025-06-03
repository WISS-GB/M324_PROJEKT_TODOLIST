package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Task;
import com.example.demo.repository.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskControllier {

    @Autowired
    private TaskRepository taskRepository
    
    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskRepository.findAll())
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<List<Task>> getTaskById() {
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity<String> addTask() {
        System.out.println("API EP /tasks: " + taskdescription);
        Task t = new Task();
        t.setTaskdescription(taskdescription);
        retun ResponseEntity.ok("Ok");
    }

}
