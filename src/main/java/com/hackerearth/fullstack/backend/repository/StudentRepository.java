package com.hackerearth.fullstack.backend.repository;

import com.hackerearth.fullstack.backend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student,Long> {
    public Student getByRoll(String roll);
    public Student findById(String id);
    public List<Student> getByName(String name);

;
}
