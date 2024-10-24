package com.example.CraftProject.service;


import com.example.CraftProject.model.Sum;
import com.example.CraftProject.repository.SumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdditionService {

    @Autowired
    private SumRepository sumRepository;

    public Sum addNumbers(int number1, int number2) {
        int sum = number1 + number2;
        Sum calculation = new Sum(number1, number2, sum);
        return sumRepository.save(calculation);
    }
}
//curl -X POST http://localhost:8080/api/v1/add -u user:password -H "Content-Type: application/json" -d '{"number1": 11, "number2": 7}'
// curl -u user:password -X POST http://localhost:8080/api/v1/add -H "Content-Type: application/json" -d '{"number1": 11, "number2": 37}'