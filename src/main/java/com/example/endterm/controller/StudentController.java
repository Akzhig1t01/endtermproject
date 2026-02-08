package com.example.endterm.controller;

import com.example.endterm.model.Student;
import com.example.endterm.service.StudentService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @PostMapping
    public void create(@RequestBody Student student) {
        service.createStudent(student);
    }
}