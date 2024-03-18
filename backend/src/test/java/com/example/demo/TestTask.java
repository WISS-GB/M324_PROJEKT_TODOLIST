package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;



public class TestTask {

        @Test
    public void testSetGetTaskDescription() {
        String desc = "TestTask";
        Task task = new Task();
        task.setTaskdescription(desc);
        assertNotEquals("Unerwarteter Wert", task.getTaskdescription());
    }

}
