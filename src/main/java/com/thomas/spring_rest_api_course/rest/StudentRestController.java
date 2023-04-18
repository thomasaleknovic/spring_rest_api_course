package com.thomas.spring_rest_api_course.rest;

import com.thomas.spring_rest_api_course.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){

        theStudents = new ArrayList<>();
        theStudents.add(new Student("Luke", "Skywalker", 1));
        theStudents.add(new Student("Max", "Herber", 2));
        theStudents.add(new Student("Jack", "Kenobi", 3));

    }

    @GetMapping("/students")
    public List<Student> getStudentsList(){


        return this.theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        return this.theStudents.get(studentId-1);

    }
}
