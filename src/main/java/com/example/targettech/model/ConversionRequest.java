package com.example.targettech.model;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class ConversionRequest {
    @NotBlank(message = "conversion type can't be empty!")
    String type;
    String values;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }
}
