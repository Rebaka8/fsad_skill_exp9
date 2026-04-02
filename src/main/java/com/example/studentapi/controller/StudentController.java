package com.example.studentapi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import com.example.studentapi.exception.StudentNotFoundException;
import com.example.studentapi.model.Student;

@RestController
public class StudentController {

    private Map<Integer, Student> students = new HashMap<>();

    public StudentController() {
        students.put(1, new Student(1, "Alice", "Computer Science"));
        students.put(2, new Student(2, "Bob", "Information Technology"));
    }

    @GetMapping("/student/{id}")
    public Student getStudent(@PathVariable int id) {

        Student student = students.get(id);

        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + id + " not found");
        }

        return student;
    }
}