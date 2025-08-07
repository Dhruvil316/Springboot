package com.dhruvil.learnSpringbootApp.controller;

import com.dhruvil.learnSpringbootApp.dto.StudentDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// checkout the difference between the Controller nad RestController ( return response in json )
// It belongs to Spring Web ( HTTP Layer )
// The row mapper is of JDBC layer -> converts the query results

@RestController
public class StudentController {
    @GetMapping("/student")
    public StudentDto getStudent () {
//        this java object gets converted into json by HttpMessageConverter
        return new StudentDto(41 , "Dhruvil" , "work.dhruvilrana@gmail.com" ) ;
    }

}
