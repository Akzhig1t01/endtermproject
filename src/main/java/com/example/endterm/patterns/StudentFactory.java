package com.example.endterm.patterns;

import com.example.endterm.model.Student;

public class StudentFactory {
    public static Student create(String name, String email, int age) {
        return new Student.StudentBuilder()
                .setName(name)
                .setEmail(email)
                .setAge(age)
                .build();
    }
}