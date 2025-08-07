package com.dhruvil.learnSpringbootApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//this tag auto create the table of student in database
//This mapping of object to relation database is called ORM ( using  hibernate )

@Entity
@Setter
@Getter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;

    private String name ;
    private String email ;
}

//You cannot connect the controller directly to entity
//You require the query interface to connect : called repository