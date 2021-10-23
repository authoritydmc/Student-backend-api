package com.authoritydmc.fullstack.backend.controller;
import com.authoritydmc.fullstack.backend.exception.CustomException;

import com.authoritydmc.fullstack.backend.model.Student;

import com.authoritydmc.fullstack.backend.payload.request.StudentRequest;

import com.authoritydmc.fullstack.backend.repository.StudentRepository;
import com.authoritydmc.fullstack.backend.services.StudentService;
import com.authoritydmc.fullstack.backend.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:5000")
@RestController
@RequestMapping("/api/v1")
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    private StudentRepository studentRepository;


    @PostMapping("/student")
    public Map<String,Object> addStudent(@RequestBody StudentRequest studentRequest) throws CustomException {

        /*
        Complete this function to get a post request as a student taking
        the parameters as Student Name and Student Roll Number
        */
        if(studentRequest.getName()==null||studentRequest.getName().length()==0){
            throw new CustomException(Constants.INVALID_NAME_MESSAGE,Constants.INVALID_NAME);
        }
        if(studentRequest.getRoll()==null||studentRequest.getRoll().length()==0){
            throw new CustomException(Constants.INVALID_ROLL_MESSAGE,Constants.INVALID_ROLL);
        }
        Student student=studentRepository.getByRoll(studentRequest.getRoll());
        if(student!=null){
            throw new CustomException(Constants.STUDENT_ALREADY_PRESENT_MESSAGE,Constants.STUDENT_ALREADY_PRESENT);
        }
        Student rstu= studentService.addStudent(new Student(studentRequest.getName(),studentRequest.getRoll()));
        Map <String,Object> returnVal=new HashMap<>();
        returnVal.put("success",true);
        returnVal.put("student",rstu);
        return  returnVal;


    }

    @DeleteMapping("/student/{id}")
    public Map<String,Object> deleteStudent(@PathVariable long id) throws CustomException {

        /*
        Complete this function to delete as a student taking
        the parameters as student id
        */
        Optional<Student> student=studentRepository.findById(id);
        if(!student.isPresent()){
            throw new CustomException(Constants.NO_SUCH_STUDENT_MESSAGE,Constants.NO_SUCH_STUDENT);
        }
        studentService.deleteStudent(student.get());
       //
        Map<String,Object> returnVal=new HashMap<>();
        returnVal.put("success",true);
        returnVal.put("student",student.get());
        return returnVal;

    }

    @GetMapping("/student")
    public List<Student> getAllStudents(){

        List<Student> students=studentService.getAllStudents();



        return students;

    }
    @GetMapping("/student/find")
    public Map<String,Object> findByMethod(@RequestParam String method,@RequestParam String param){



        Map<String,Object> returnVal=new HashMap<>();
        if(method.equals("name")) {

            List<Student> students=studentService.findByName(param);
            if(students.size()!=0)
            returnVal.put("success", true);
            else returnVal.put("success",false);
            returnVal.put("students", students);
            returnVal.put("total", students.size());
            returnVal.put("method","Byname");
        }else if (method.equals("roll"))
        {

            returnVal.put("method","ByRoll");

            Student student=studentService.findByRoll(param);
            if(student!=null){
                returnVal.put("success", true);
                returnVal.put("student",student);

           }else
               returnVal.put("success",false);



        }else if (method.equals("id"))
        {
            returnVal.put("success", true);
            returnVal.put("method","ByID");

            Student student=studentService.findById(param);

            if(student!=null){
                returnVal.put("success", true);
                returnVal.put("student",student);

            }else
                returnVal.put("success",false);

        }
        return returnVal;

    }

 


}
