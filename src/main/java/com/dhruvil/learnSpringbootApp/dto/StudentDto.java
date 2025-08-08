package com.dhruvil.learnSpringbootApp.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor // required for the model mapper
public class StudentDto {
    private long id ;
    private String name ;
    private String email ;


//    if I don't want to write this code of getters setters and constructor : use @Data of lombok , it will create
//    automatically during .class file in byte code
    public StudentDto(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


}
