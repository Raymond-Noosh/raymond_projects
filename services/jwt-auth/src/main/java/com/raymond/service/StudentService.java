package com.raymond.service;

import com.raymond.entity.Student;
import com.raymond.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by Raymond Kwong on 12/8/2018.
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student findStudentById(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();
            return student;
        }
        else {
            return null;
        }
    }

    public Student findStudentByUsername(String username) {
        Student student = studentRepository.findByUsername(username);
        return student;
    }

}
