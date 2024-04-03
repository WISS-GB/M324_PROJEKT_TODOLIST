package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.example.models.Task;
import com.example.repository.TaskRepository;

@DataJpaTest
public class RepositoryTest {
    
    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void testFindTaskByDescription() {
        final String test_str = "test_str";
        
        // Überprüfen, dass die Methode findByTaskdescription() null zurückgibt, wenn keine entsprechende Aufgabe gefunden wird
        Task task = taskRepository.findByTaskdescription(test_str);
        assertNull(task, "Should not find a task with description: " + test_str);

        // Speichern einer Aufgabe mit der Beschreibung test_str
        Task t = new Task();
        t.setTaskdescription(test_str);
        taskRepository.save(t);

        // Überprüfen, ob die gespeicherte Aufgabe erfolgreich gefunden wird
        task = taskRepository.findByTaskdescription(test_str);
        assertNotNull(task, "Task with description: " + test_str + " should be found");
        assertEquals(t.getTaskdescription(), task.getTaskdescription());
    }
}