package com.socialmedia.api.com.socialmedia.api.Users;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserControllerResourse {
    private UserDataBaseService dataBaseService;

    public UserControllerResourse(UserDataBaseService dataBaseService){
        this.dataBaseService = dataBaseService;
    }

    @GetMapping("/users")
    public List<User> FetchUsers(){
        return dataBaseService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User FetchUser(@PathVariable Integer id){
        return dataBaseService.findOne(id);
    }

}
