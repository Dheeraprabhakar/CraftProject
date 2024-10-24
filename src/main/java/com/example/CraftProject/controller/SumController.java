package com.example.CraftProject.controller;

import com.example.CraftProject.model.Sum;
import com.example.CraftProject.service.AdditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class SumController {

    @Autowired
    private AdditionService additionService;

    @GetMapping("/add")
    public Sum addNumbers(@RequestParam int number1, @RequestParam int number2) {
        return additionService.addNumbers(number1, number2);
    }
}

//curl -X GET "http://localhost:8080/api/v1/add?number1=11&number2=37" -u "user:password" -v
