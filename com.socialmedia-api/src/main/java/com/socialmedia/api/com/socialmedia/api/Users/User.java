package com.socialmedia.api.com.socialmedia.api.Users;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {

    private  Integer id;
    @Size(min = 2, message = "Atleast minimum of 2 charater is required.")
    private String name;
    @Past(message = "Data must be in the past.")
    private LocalDate dateOfBirth;

    public User(Integer id, String name, LocalDate dateOfBirth){
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;

    }
    public LocalDate getDateOfBirth(){
        return dateOfBirth;
    }
    public void setDateOfBirth( LocalDate dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }
}
