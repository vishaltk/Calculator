package com.calculator.dto;

import lombok.Builder;

@Builder
public class NumericResponse {
    int answer;

    @Override
    public String toString() {
        return "answer = "+answer;
    }
}
