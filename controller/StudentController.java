package com.example.demo.controller;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.requests.StudentRequest;
import com.example.demo.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/add")
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
        Student student = mapStudentRequestToStudent(studentRequest);
        student = studentRepository.save(student);
        StudentResponse studentResponse = mapStudentRequestToStudentResponse(student);
        return studentResponse;
    }

    private Student mapStudentRequestToStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setAddress(studentRequest.getAddress());
        student.setName(studentRequest.getName());
        student.setPhone(studentRequest.getPhone());
        return student;
    }

    private StudentResponse mapStudentRequestToStudentResponse(Student student) {
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setPhone(student.getPhone());
        studentResponse.setAddress(student.getAddress());
        studentResponse.setRollNo(student.getRollNo());
        studentResponse.setName(student.getName());
        studentResponse.setCode(HttpStatus.CREATED.value());
        studentResponse.setStatus(HttpStatus.CREATED.name());
        return studentResponse;
    }

    @GetMapping("/get")
    public StudentResponse getStudent(@RequestParam int rollNo) {
        Optional<Student> student = studentRepository.findById(rollNo);
        StudentResponse studentResponse = mapStudentRequestToStudentResponse(student.get());
        return studentResponse;
    }
}
