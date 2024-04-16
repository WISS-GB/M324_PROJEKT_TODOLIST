package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Task;
import com.example.repository.TaskRepository;

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
	public ResponseEntity<String> addTask(@RequestBody String taskdescription) {
		
		Task task = new Task();
		task.setTaskdescription(taskdescription);
		taskRepository.save(task);

		return ResponseEntity.ok("Created task with id:"+task.getId()+", taskdescription:"+task.getTaskdescription()+"");
	}

	@CrossOrigin
    @PostMapping("/delete")
    public ResponseEntity<String> delTask(@RequestBody String id) {
		System.out.println(id);
        try {
            int taskId = Integer.parseInt(id);
            Optional<Task> taskToDelete = taskRepository.findById(taskId);
            if (taskToDelete.isPresent()) {
                taskRepository.delete(taskToDelete.get());
                return ResponseEntity.ok("Task '" + taskToDelete.get().getTaskdescription() + "' has been deleted");
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid task ID format");
        }
    }
}
