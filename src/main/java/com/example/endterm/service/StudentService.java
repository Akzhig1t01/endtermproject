package com.example.endterm.service;

import com.example.endterm.model.Student;
import com.example.endterm.patterns.LogSingleton;
import com.example.endterm.patterns.StudentCache;
import com.example.endterm.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final String CACHE_KEY = "all_students_list";

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        List<Student> cached = StudentCache.getInstance().get(CACHE_KEY);

        if (cached != null) {
            LogSingleton.getInstance().log("[LOG]: CACHE HIT - Returning from memory");
            return cached;
        }

        LogSingleton.getInstance().log("[LOG]: CACHE MISS - Fetching from Database");
        List<Student> students = repository.findAll();
        StudentCache.getInstance().put(CACHE_KEY, students);

        return students;
    }

    public void createStudent(Student student) {
        repository.save(student);
        StudentCache.getInstance().clear();
        LogSingleton.getInstance().log("[LOG]: Student added, cache cleared");
    }
}