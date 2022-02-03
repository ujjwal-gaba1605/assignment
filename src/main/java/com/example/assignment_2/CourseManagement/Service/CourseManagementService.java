package com.example.assignment_2.CourseManagement.Service;

import com.example.assignment_2.CourseManagement.Course;
import com.example.assignment_2.CourseManagement.Repository.CourseManagementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseManagementService {

    private final CourseManagementRepository courseManagementRepository;

    @Autowired
    public CourseManagementService(CourseManagementRepository courseManagementRepository) {
        this.courseManagementRepository = courseManagementRepository;
    }

    public List<Course> list() {
        return courseManagementRepository.findAll();
    }

    public Course add(Course course) {
        course.setCreatedAt(LocalDateTime.now());
        course.setUpdatedAt(null);
        return courseManagementRepository.save(course);
    }

    public Course getCourseById(Long id) {
        return courseManagementRepository.findById(id).get();
    }
}
