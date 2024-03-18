package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
       
        DemoApplication demoApp = new DemoApplication();
       
        assertEquals(0, demoApp.getTasks().size(), "Initial task list solte ler sein");
       
        demoApp.addTask("{\"taskdescription\":\"Task 1\"}");
        assertEquals(1, demoApp.getTasks().size(), "Task list size solte 1 sein anch hinzufügen");
     
        demoApp.delTask("{\"taskdescription\":\"Task 1\"}");
        assertEquals(0, demoApp.getTasks().size(), "Task list size solte 0 sein nach dem löschen der task");
    }
}