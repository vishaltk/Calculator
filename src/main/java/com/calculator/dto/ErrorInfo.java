package com.calculator.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorInfo {
    ErrorCode errorCode;
    String message;
}
