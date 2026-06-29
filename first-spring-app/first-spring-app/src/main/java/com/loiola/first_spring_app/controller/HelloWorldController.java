package com.loiola.first_spring_app.controller;

import com.loiola.first_spring_app.domain.User;
import com.loiola.first_spring_app.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {

    @Autowired
    private HelloWorldService helloWorldService;

    @GetMapping("/")
    public String HelloWorld() {
        return helloWorldService.helloWorld("Gustavo");
    }

    @PostMapping("/{id}")
    public String HelloWorldPost(@PathVariable("id") String id,@RequestParam(value="filter", defaultValue = "empty") String filter, @RequestBody User body) {
        return "Hello World " + body.getName() + id;
    }
}
