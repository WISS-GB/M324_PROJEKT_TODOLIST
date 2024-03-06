package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

/**
 * This is a demo application that provides a RESTful API for a simple ToDo list
 * without persistence.
 * The endpoint "/" returns a list of tasks.
 * The endpoint "/tasks" adds a new unique task.
 * The endpoint "/delete" suppresses a task from the list.
 * The task description transferred from the (React) client is provided as a
 * request body in a JSON structure.
 * The data is converted to a task object using Jackson and added to the list of
 * tasks.
 * All endpoints are annotated with @CrossOrigin to enable cross-origin
 * requests.
 *
 * @author luh
 */
@RestController
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	private List<Task> tasks = new ArrayList<>();

	@Autowired
	private TaskRepository taskRepository;

	@CrossOrigin
	@GetMapping("/")
	public List<Task> getTasks() {

		System.out.println("API EP '/' returns task-list of size " + tasks.size() + ".");
		if (tasks.size() > 0) {
			int i = 1;
			for (Task task : tasks) {
				System.out.println("-task " + (i++) + ":" + task.getTaskdescription());
			}
		}
		return tasks; // actual task list (internally converted to a JSON stream)
	}

	

	@CrossOrigin
	@PostMapping("/tasks")
	public ResponseEntity<Task> addTask(@RequestBody String taskdescription) {
		
		Task task= new Task();
		task.setTaskdescription(taskdescription);
		taskRepository.save(task);
		return ResponseEntity.ok(task);
	}

	@CrossOrigin
	@PostMapping("/delete")
	public String delTask(@RequestBody @RequestParam String taskdescription) {
		System.out.println("API EP '/delete': '" + taskdescription + "'");
		
		Task toDeleteTask = taskRepository.findbyTaskdescription(taskdescription);
		

		if (toDeleteTask != null) {
			taskRepository.delete(toDeleteTask);
			return "gelöscht";
		}
			return "redirect:/";
		}
		
	}

