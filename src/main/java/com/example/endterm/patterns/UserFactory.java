package com.example.endterm.patterns;

import com.example.endterm.model.Student;

public class UserFactory {
    public static Student createStudent(String name, String email, int age) {
        return new Student.StudentBuilder()
                .setName(name)
                .setEmail(email)
                .setAge(age)
                .build();
    }
}