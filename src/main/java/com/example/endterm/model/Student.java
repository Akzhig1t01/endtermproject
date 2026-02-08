package com.example.endterm.model;

public class Student {
    private int id;
    private String name;
    private String email;
    private int age;

    public Student() {}

    private Student(StudentBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getAge() { return age; }

    public static class StudentBuilder {
        private int id;
        private String name;
        private String email;
        private int age;

        public StudentBuilder setId(int id) { this.id = id; return this; }
        public StudentBuilder setName(String name) { this.name = name; return this; }
        public StudentBuilder setEmail(String email) { this.email = email; return this; }
        public StudentBuilder setAge(int age) { this.age = age; return this; }
        public Student build() { return new Student(this); }
    }
}