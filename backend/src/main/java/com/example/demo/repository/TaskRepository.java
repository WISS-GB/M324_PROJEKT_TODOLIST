package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.demo.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    
    public Optional<Task> findByTaskdescription(String taskdescription);
}
