package com.dhruvil.learnSpringbootApp.service.impl;

import com.dhruvil.learnSpringbootApp.dto.AddStudentReqDto;
import com.dhruvil.learnSpringbootApp.dto.StudentDto;
import com.dhruvil.learnSpringbootApp.entity.Student;
import com.dhruvil.learnSpringbootApp.respository.StudentRepo;
import com.dhruvil.learnSpringbootApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor // this auto create the constructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    private final ModelMapper modelMapper; // final nahi hoga to constructor injectino nahi hoga via @RequiredArgsConstructor


    //    we write all the business logic here
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        List<StudentDto> studentDtosList = students.stream().map(student -> new StudentDto(student.getId(),
                student.getName(), student.getEmail())).toList();
        return studentDtosList;
    }

    @Override
    public StudentDto getStudentById(long id) {
//      converting the entity to dto each and every time is cumbersome so we use the model mapper library  ;
        Student s = studentRepo.findById(id).orElseThrow(() -> new IllegalArgumentException(" Student not found "));
        return modelMapper.map(s, StudentDto.class); // this mapping is done by fields , so make sure that dto
//      and entity should have same fields
    }

    @Override
    public StudentDto createNewStudent(AddStudentReqDto addStudentReqDto) {
        Student newStudent = modelMapper.map(addStudentReqDto, Student.class);
        Student s = studentRepo.save(newStudent);
        return modelMapper.map(s, StudentDto.class);
    }

    @Override
    public StudentDto deleteStudentById(long id) {
        Student student = studentRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));

        studentRepo.delete(student); // ✅ delete the entity

        return modelMapper.map(student, StudentDto.class); // ✅ return deleted student's DTO
    }

    @Override
    public StudentDto updateWholeStudentById(long id, AddStudentReqDto addStudentReqDto) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found")
        );

//        this adds the fields to student
        modelMapper.map(addStudentReqDto , student) ;
        student = studentRepo.save(student) ;
        return modelMapper.map(student , StudentDto.class);
    }

    @Override
    public StudentDto patchStudent(long id, Map<String, Object> updates) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Student not found")
        );

        updates.forEach((key , value ) -> {
            switch (key) {
                case "name" :
                    student.setName((String) value);
                    break;
                case "email" :
                    student.setEmail((String) value);
                    break;
                default:
                    throw new IllegalArgumentException("field is not supported ") ;
            }
        });

        Student savedStudent = studentRepo.save(student) ;
        return modelMapper.map(savedStudent , StudentDto.class) ;
    }

}
