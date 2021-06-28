package com.example.jpa.bookmanager;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/fxxku")
    public String helloWorld(){
        return "fxxk u";
    }

}
