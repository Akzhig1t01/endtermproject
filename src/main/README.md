Student Management System - Project Report 

Project Goal

The goal of this project was to build a backend system for student management using Spring Boot and PostgreSQL, while correctly implementing design patterns like Singleton and Factory.

How it's built

I used a layered architecture to keep the code clean:

Controller: Handles incoming API requests.

Service: Where the main logic happens (and where I used the Singleton).

Repository: Raw JDBC code to talk to PostgreSQL.

Model: The data structure for a Student.

Applied Design Patterns

Singleton (LogSingleton): I created this class to make sure we only have one logger instance throughout the whole app. It prevents creating unnecessary objects and keeps all console logs in one style.

Factory (StudentFactory): This class is responsible for creating Student objects. Instead of calling new Student() everywhere, I use the factory. Inside, it uses a Builder to set up the fields (name, email, age) step-by-step.

Database Schema

The project uses a simple PostgreSQL table:

CREATE TABLE students (

id SERIAL PRIMARY KEY,

name VARCHAR(100) NOT NULL,

email VARCHAR(100) UNIQUE,

age INT
);

How to verify the work

Launch the app: Run Application.java in IntelliJ.

Check API: Go to http://localhost:8080/api/students in your browser. You should see a JSON list of students.

Check Logs: Look at the IDEA console. You will see lines starting with [LOG] — this is the Singleton in action.

Project Structure

controller/ — StudentController.java

model/ — Student.java

patterns/ — StudentFactory.java, LogSingleton.java

repository/ — StudentRepository.java

service/ — StudentService.java