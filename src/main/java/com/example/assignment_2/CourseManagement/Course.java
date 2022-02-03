package com.example.assignment_2.CourseManagement;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course")
public class Course {
    @JsonProperty
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty
    @Column(name = "name")
    private String name;

    @JsonProperty
    @Column(name = "description")
    private String description;

    @JsonProperty
    @Column(name = "created_at")
    private LocalDateTime created_at;

    @JsonProperty
    @Nullable
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    public Course() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdatedAt() {
        return updated_at;
    }

    public void setUpdatedAt(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public Course(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Course(String description) {
        this.description = description;
    }
}
