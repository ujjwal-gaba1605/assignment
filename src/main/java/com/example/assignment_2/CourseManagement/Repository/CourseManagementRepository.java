package com.example.assignment_2.CourseManagement.Repository;


import com.example.assignment_2.CourseManagement.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseManagementRepository extends JpaRepository<Course,Long> {

}
