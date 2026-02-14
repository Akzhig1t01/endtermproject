package com.example.endterm.patterns;

import com.example.endterm.model.Student;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StudentCache {
    private static StudentCache instance;
    private final Map<String, List<Student>> storage = new ConcurrentHashMap<>();

    private StudentCache() {}

    public static synchronized StudentCache getInstance() {
        if (instance == null) {
            instance = new StudentCache();
        }
        return instance;
    }

    public List<Student> get(String key) {
        return storage.get(key);
    }

    public void put(String key, List<Student> data) {
        storage.put(key, data);
    }

    public void clear() {
        storage.clear();
    }
}