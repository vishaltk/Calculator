package com.calculator.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommandResponse<T> {
    T data;
    ErrorInfo errorInfo;

    @Override
    public String toString() {
        if(null == errorInfo)
            return data.toString();
        else
            return errorInfo.toString();
    }
}
