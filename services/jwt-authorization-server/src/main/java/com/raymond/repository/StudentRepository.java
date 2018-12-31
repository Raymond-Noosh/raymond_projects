package com.raymond.repository;

import com.raymond.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Raymond Kwong on 12/8/2018.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
