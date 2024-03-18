package com.example.demo.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.models.Task;

public class TestTask {

    @Test
    public void testSetGetTaskDescription() {
        String desc = "TestTask";
        Task task = new Task();
        
        // Setze die Beschreibung und überprüfe, ob sie korrekt gesetzt wurde
        task.setTaskdescription(desc);
        assertEquals(desc, task.getTaskdescription());
        
        // Überschreibe die Beschreibung und überprüfe erneut
        String newDesc = "UpdatedTaskDescription";
        task.setTaskdescription(newDesc);
        assertEquals(newDesc, task.getTaskdescription());
    }

    @Test
    public void testSetGetId() {
        int id = 10;
        Task task = new Task();
        task.setId(id);
        assertEquals(id, task.getId());
    }
}
