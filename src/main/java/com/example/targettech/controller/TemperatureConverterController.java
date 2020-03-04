package com.example.targettech.controller;

import com.example.targettech.services.TemperatureService;
import com.example.targettech.model.ConversionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TemperatureConverterController {

    @Autowired
    private TemperatureService tempService;

    @PostMapping("/api/convert")
    public ResponseEntity<?> convert(@Valid @RequestBody ConversionRequest conversionRequest) {

        List<String> resultFromService = tempService.convertValues(conversionRequest);
        return ResponseEntity.ok(String.join(",", resultFromService));
    }
}
