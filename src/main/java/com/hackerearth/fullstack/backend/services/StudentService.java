package com.hackerearth.fullstack.backend.services;

import com.hackerearth.fullstack.backend.model.Student;

import com.hackerearth.fullstack.backend.payload.response.MessageResponse;
import com.hackerearth.fullstack.backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

@Autowired
    StudentRepository studentRepository;


public List<Student> getAllStudents()
{
    List<Student> students=new ArrayList<Student>();

    studentRepository.findAll().forEach(stu->students.add(stu));
    return students;
}

public Student addStudent(Student student)
{
    studentRepository.save(student);
    return student;
}

public Student deleteStudent(Student student)
{

    studentRepository.delete(student);
return student;
}
public List<Student> findByName(String name)
{

   return studentRepository.getByName(name);
}

public Student findByRoll(String roll)
{
    return studentRepository.getByRoll(roll);
}
public Student findById(String id)
{
    Optional<Student> student=studentRepository.findById(Long.parseLong(id));
    if (student.isPresent())
        return student.get();
    else
        return null;
}

}
