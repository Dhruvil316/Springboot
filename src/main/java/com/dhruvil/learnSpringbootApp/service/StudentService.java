package com.dhruvil.learnSpringbootApp.service;

import com.dhruvil.learnSpringbootApp.dto.AddStudentReqDto;
import com.dhruvil.learnSpringbootApp.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {
    List<StudentDto> getAllStudents () ;
    StudentDto getStudentById ( long id ) ;
    StudentDto createNewStudent (AddStudentReqDto addStudentReqDto) ;
    StudentDto deleteStudentById ( long id ) ;
    StudentDto updateWholeStudentById ( long id , AddStudentReqDto addStudentReqDto) ;
    StudentDto patchStudent ( long id , Map< String , Object > updates ) ;
}
