package com.example.targettech.controller;

import com.example.targettech.model.CalculatorRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CalculatorController {

    @PostMapping("/api/calculate")
    public ResponseEntity<?> calculate(@Valid @RequestBody CalculatorRequest calculatorRequest) {
    String op = calculatorRequest.getOperation();
    int result = 0;
    int num1 = calculatorRequest.getNumber1();
    int num2 = calculatorRequest.getNumber2();
     if(op.equals("add")){
         result = num1 + num2;
     }
     if(op.equals("sub")){
         result = num1 - num2;
     }
     if(op.equals("div")){
         result = num1/num2;
     }
     if(op.equals("mul")){
         result = num1 * num2;
     }
     return ResponseEntity.ok(result);
    }
}
