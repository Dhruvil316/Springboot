package com.dhruvil.learnSpringbootApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class StudentDto {
    private long id ;
    private String name ;
    private String email ;


//    if I dont want to write this code of getters setters and constructor : use @Data of lombok , it will create
//    automatically during .class file in byte code
    public StudentDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
//
//    public StudentDto() {
//    }
}
