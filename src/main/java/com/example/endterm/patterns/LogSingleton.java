package com.example.endterm.patterns;

public class LogSingleton {
    private static LogSingleton instance;
    private LogSingleton() {}
    public static LogSingleton getInstance() {
        if (instance == null) {
            instance = new LogSingleton();
        }
        return instance;
    }
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}