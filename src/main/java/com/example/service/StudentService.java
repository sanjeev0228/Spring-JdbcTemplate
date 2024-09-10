package com.example.service;

import com.example.model.Student;
import com.example.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private StudentRepo studentRepo;

    @Autowired
    public StudentRepo getStudentRepo() {
        return studentRepo;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

//    public void addStudent(Student s) {
//       StudentRepo.save();
//
//    }

    public List<Student> getStudent() {
        return studentRepo.findAll();
    }
}
