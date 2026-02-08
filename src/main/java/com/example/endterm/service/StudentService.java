package com.example.endterm.service;

import com.example.endterm.model.Student;
import com.example.endterm.patterns.LogSingleton;
import com.example.endterm.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        LogSingleton.getInstance().log("Fetching all students from database");
        return repository.findAll();
    }

    public void createStudent(Student student) {
        LogSingleton.getInstance().log("Creating student: " + student.getName());
        repository.save(student);
    }
}