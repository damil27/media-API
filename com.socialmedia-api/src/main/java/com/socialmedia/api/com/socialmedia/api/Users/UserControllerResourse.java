package com.socialmedia.api.com.socialmedia.api.Users;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
        User user = dataBaseService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id" + id);
        }
        return user;
    }

    @PostMapping("users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
          dataBaseService.save(user);
          return ResponseEntity.created(null).body(user);
    }
    @DeleteMapping("/users/{id}")
    public Optional<User> deleteUser(@PathVariable() Integer id){
        Optional<User> user = dataBaseService.deleteUser(id);
        if(user.isEmpty()){
            throw  new UserNotFoundException( id + " This user user does not exist in the database.");
        }
        return user;
        
    }

}
