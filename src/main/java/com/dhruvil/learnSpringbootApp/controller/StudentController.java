package com.dhruvil.learnSpringbootApp.controller;

import com.dhruvil.learnSpringbootApp.dto.StudentDto;
import com.dhruvil.learnSpringbootApp.entity.Student;
import com.dhruvil.learnSpringbootApp.respository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// checkout the difference between the Controller nad RestController ( return response in json )
// It belongs to Spring Web ( HTTP Layer )
// The row mapper is of JDBC layer -> converts the query results

@RestController
public class StudentController {

    private final StudentRepo studentRepo ;

    @Autowired
    public StudentController ( StudentRepo studentRepo ) {
        this.studentRepo = studentRepo ;
    }

    @GetMapping("/student")
    public List<Student> getStudent () {
//        this java object gets converted into json by HttpMessageConverter
        return studentRepo.findAll() ;
    }

}

//note : We try not to expose the Student entity for security reasons . We only expose Dtos .