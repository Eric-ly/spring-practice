package com.example.spring_mvc_test.service;

import com.example.spring_mvc_test.model.Student;

public class Service {
    public String check() {
        return "success";
    }

    public String showStudentName(Student student) {
        if (student != null) {
            return student.getName();
        }
        return "";
    }
}
