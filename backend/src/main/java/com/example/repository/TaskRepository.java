package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.models.Task;



public interface TaskRepository extends JpaRepository<Task, Integer> {
    public Task findByTaskdescription(String taskdescription);
    public Optional<Task> findById(Integer id);
}
