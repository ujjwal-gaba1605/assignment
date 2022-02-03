package com.example.assignment_2.CourseManagement.Controller;

import com.example.assignment_2.Assignment2Application;
import com.example.assignment_2.CourseManagement.Course;
import com.example.assignment_2.CourseManagement.Service.CourseManagementService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = Assignment2Application.class)
@AutoConfigureMockMvc
@WithMockUser
class CourseManagementControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseManagementService courseManagementService;

    @Test
    public void shouldReturnTheListOfCourses() throws Exception {
        LocalDateTime time = LocalDateTime.now();
        Course course = new Course("hi", "hi everyone");
        course.setCreatedAt(time);

        when(courseManagementService.list()).thenReturn(List.of(course));

        mockMvc.perform(get("/courses/get"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson(List.of(course))));
    }

    private String expectedJson(List<Course> courses) throws JsonProcessingException {
        ObjectMapper jsonMapper = new ObjectMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return jsonMapper.writeValueAsString(courses);
    }

}