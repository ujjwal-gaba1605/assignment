package com.example.assignment_2.CourseManagement.Controller;

import com.example.assignment_2.CourseManagement.Course;
import com.example.assignment_2.CourseManagement.ExceptionHandling.ErrorResponse;
import com.example.assignment_2.CourseManagement.Service.CourseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/courses")
public class CourseManagementController {
    private final CourseManagementService courseManagementService;

    @Autowired
    public CourseManagementController(CourseManagementService courseManagementService) {
        this.courseManagementService = courseManagementService;
    }

    @GetMapping("/get")
    public List<Course> list() {
        return courseManagementService.list();
    }

    @GetMapping("/get/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseManagementService.getCourseById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Object> add(@RequestBody Course course) {
        if (course.getName() == null) {
            ErrorResponse errorResponse = new ErrorResponse("Name is required");
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(errorResponse);
        }
        List<Course> courseList = courseManagementService.list();
        for (Course existingCourse : courseList) {
            if (Objects.equals(existingCourse.getName(), course.getName())) {
                ErrorResponse errorResponse = new ErrorResponse("Course with this name already exists");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(courseManagementService.add(course));
    }

}


