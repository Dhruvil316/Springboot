package com.dhruvil.learnSpringbootApp.controller;
import com.dhruvil.learnSpringbootApp.dto.AddStudentReqDto;
import com.dhruvil.learnSpringbootApp.dto.StudentDto;
import com.dhruvil.learnSpringbootApp.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// checkout the difference between the Controller nad RestController ( return response in json )
// It belongs to Spring Web ( HTTP Layer )
// The row mapper is of JDBC layer -> converts the query results

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService ;


    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> getStudent () {
//        this java object gets converted into json by HttpMessageConverter
//        way one to return ok status
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents()) ;
    }


    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentByID (@PathVariable("id") long userid ) {
        return ResponseEntity.ok(studentService.getStudentById(userid));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent (@RequestBody AddStudentReqDto addStudentReqDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body( studentService.createNewStudent(addStudentReqDto)) ;
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable("id") long userid) {
        try {
            StudentDto deletedStudent = studentService.deleteStudentById(userid);
            return ResponseEntity.ok(deletedStudent);
        } catch (IllegalArgumentException e) {
//            hey brother
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }

//    it over-write the whole object
    @PutMapping("/students/{id}")
    public  ResponseEntity<?> updateWholeStudent ( @PathVariable ("id") long userid , @RequestBody AddStudentReqDto addStudentReqDto) {
        try{
            StudentDto updatedStudent = studentService.updateWholeStudentById(userid , addStudentReqDto) ;
            return ResponseEntity.ok(updatedStudent) ;
        }
        catch ( IllegalArgumentException e ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found") ;
        }
    }

    @PatchMapping ( "/students/{id}")
    public ResponseEntity<?> patchStudent (@PathVariable("id") long userid , @RequestBody Map< String , Object > updates ) {
        try{
            StudentDto updatedStudent = studentService.patchStudent(userid , updates) ;
            return ResponseEntity.ok(updatedStudent) ;
        }
        catch ( IllegalArgumentException e ) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found") ;
        }
    }

}

//note : We try not to expose the Student entity for security reasons . We only expose Dtos .
// In the next video we will be learning the model mapper