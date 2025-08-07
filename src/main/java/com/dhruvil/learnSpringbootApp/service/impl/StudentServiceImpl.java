package com.dhruvil.learnSpringbootApp.service.impl;

import com.dhruvil.learnSpringbootApp.dto.StudentDto;
import com.dhruvil.learnSpringbootApp.entity.Student;
import com.dhruvil.learnSpringbootApp.respository.StudentRepo;
import com.dhruvil.learnSpringbootApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // this auto create the constructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    //    we write all the business logic here
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> studentDtosList = students.stream().map(student -> new StudentDto(student.getId(),
                student.getName(), student.getName())).toList();
        return studentDtosList;
    }
}
