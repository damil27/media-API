package com.socialmedia.api.com.socialmedia.api.Hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String HelloResponse(){
        return "hello there !";
    }
    @GetMapping("/first-message")
    public HelloworldBean hellobean(){
        return  new HelloworldBean("first message with Java bean");
    }
}
