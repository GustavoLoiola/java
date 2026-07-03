package com.example.test.controller;

import com.example.test.exceptions.DivisionException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String message() {
        return "First solo test";
    }

    @GetMapping("/somar")
    public int somar(@RequestParam int a, @RequestParam int b) {
        return a + b;
    }

    @GetMapping("/subtrair")
    public int subtrair(@RequestParam int a, @RequestParam int b) {
        return a - b;
    }

    @GetMapping("/dividir")
    public int dividir(@RequestParam int a, @RequestParam int b) {
        if(b == 0) { throw new DivisionException("Não é possível fazer divisão com 0.");}
        return a / b;
    }

    @GetMapping("/multiplicar")
    public int multiplicar(@RequestParam int a, @RequestParam int b) {
        return a * b;
    }
}
