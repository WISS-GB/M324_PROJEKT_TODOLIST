package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.fail;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import jakarta.transaction.Transactional;

import com.example.demo.Repository.TaskRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@ActiveProfiles("test")
public class TodoDeleteTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskRepository taskRepository;

    @Test
    @Transactional
    public void testDeleteTaskViaREST() {
        final String taskDesc = "task to delete";

        try {
            // 1. Add a task first
            JSONObject taskJson = new JSONObject();
            taskJson.put("taskdescription", taskDesc);

            String postResponse = mockMvc.perform(MockMvcRequestBuilders.post("/task")
                    .content(taskJson.toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("utf-8"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

            JSONObject createdTask = new JSONObject(postResponse);
            Long taskId = createdTask.getLong("id");

            if (taskId == null) {
                fail("Task ID not found after adding task");
            }

            // 2. Delete the task by ID
            mockMvc.perform(MockMvcRequestBuilders.delete("/task/" + taskId))
                .andExpect(MockMvcResultMatchers.status().isOk());

        } catch (Exception e) {
            fail("test failed because " + e.getMessage());
            e.printStackTrace();
        }
    }
}
