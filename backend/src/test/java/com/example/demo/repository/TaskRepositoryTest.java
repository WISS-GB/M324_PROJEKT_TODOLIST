package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.demo.model.Task;

@DataJpaTest
public class TaskRepositoryTest {

        @Autowired
        private TestEntityManager entityManager;
        
        @Autowired
        private TaskRepository taskRepository;

        @Test
        public void testSetup() {
            assertNotNull(entityManager);
        }
        
        @Test
        public void testAddFind() {
            final String taskDescription = "test";
            Task task = new Task();
            task.setTaskdescription(taskDescription);
            taskRepository.save(task);
            Optional<Task> result = taskRepository.findByTaskdescription(taskDescription);

            assertTrue(result.isPresent());
            assertEquals(taskDescription, result.get().getTaskdescription());
        }
}
