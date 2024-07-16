package com.socialmedia.api.com.socialmedia.api.Users;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class UserDataBaseService {
    private static  List<User> users = new ArrayList<>();
     static {
         users.add(new User(1, "Damilare", LocalDate.now().minusYears(30)));
         users.add(new User(2, "Kazzem", LocalDate.now().minusYears(10)));
         users.add(new User(3, "Seun", LocalDate.now().minusYears(3)));
         users.add(new User(4, "Adeole", LocalDate.now().minusYears(17)));
     }

     public List<User> getAllUsers(){
         return users;
     }
     public User findOne(Integer id){
        Predicate<User> predicate = user -> user.getId().equals(id);
         Optional<User> user = users.stream().filter(predicate).findFirst();
         return user.orElse(null);
     }

}
