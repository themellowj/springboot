package net.project.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hwController {
    @GetMapping("/hello-world")
    public  String helloworld(){
        return "Hello Daria";
    }
}
