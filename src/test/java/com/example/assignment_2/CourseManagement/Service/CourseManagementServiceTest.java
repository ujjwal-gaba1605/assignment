package com.example.assignment_2.CourseManagement.Service;

import com.example.assignment_2.CourseManagement.Course;
import com.example.assignment_2.CourseManagement.Repository.CourseManagementRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class CourseManagementServiceTest {
    private CourseManagementService courseManagementService;
    private CourseManagementRepository courseManagementRepository;

    @BeforeEach
    void setup() {
        courseManagementRepository = mock(CourseManagementRepository.class);
        courseManagementService = new CourseManagementService(courseManagementRepository);
    }

    @Test
    void shouldBeAbleToSaveCourse() {
        Course course = mock(Course.class);

        courseManagementService.add(course);

        verify(courseManagementRepository, times(1)).save(course);
    }

}