package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@RestController
@RequestMapping("/todo")
public class TaskController {

    @Autowired
	private TaskRepository taskRepository;

	@CrossOrigin
	@GetMapping("/")
	public List<Task> getTasks() {

		return taskRepository.findAll();
	}

	@CrossOrigin
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@RequestBody String taskdescription) {
		
		Task task = new Task();
		task.setTaskdescription(taskdescription);
		taskRepository.save(task);
		return ResponseEntity.ok(task);
	}

	@CrossOrigin
	@PostMapping("/delete")
	public String delTask(@RequestBody @RequestParam String taskdescription) {
		System.out.println("API EP '/delete': '" + taskdescription + "'");
		// 1. Suche Task-Datensatz mit gegebenem Inhalt in DB
		// Ändere den Rückgabetyp auf Optional<Task>
		Optional<Task> toDeleteTaskOptional = taskRepository.findByTaskdescription(taskdescription);
		// 2. Wenn Task gefunden, lösche den Datensatz in DB
		if (toDeleteTaskOptional.isPresent()) {
			Task toDeleteTask = toDeleteTaskOptional.get();
			taskRepository.delete(toDeleteTask);
			return "gelöscht";
		}

		return "nicht gefunden";
	}
    
}
