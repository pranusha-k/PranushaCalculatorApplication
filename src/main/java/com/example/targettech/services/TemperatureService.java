package com.example.targettech.services;

import com.example.targettech.model.ConversionRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TemperatureService {

    List<String> convertedValues;

    public List<String> convertValues(ConversionRequest conversionRequest) {

        convertedValues = new ArrayList<>();
        if (conversionRequest.getType().equalsIgnoreCase("C")) {
            for (String val : conversionRequest.getValues().split(",")) {
                int convertedValue = ((Integer.parseInt(val) - 32) * 5 / 9);
                convertedValues.add(Integer.toString(convertedValue));
            }
        } else if (conversionRequest.getType().equalsIgnoreCase("F")) {
            for (String val : conversionRequest.getValues().split(",")) {
                int convertedValue = ((Integer.parseInt(val) * 9 / 5) + 32);
                convertedValues.add(Integer.toString(convertedValue));
            }
        }
        return convertedValues;
    }
}
