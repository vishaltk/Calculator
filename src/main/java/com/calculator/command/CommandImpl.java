package com.calculator.command;

import com.calculator.dto.CommandResponse;
import com.calculator.dto.NumericResponse;

public enum CommandImpl implements Command{
    add {
        @Override
        public CommandResponse<NumericResponse> execute(String[] args) {
            int op1 = Integer.parseInt(args[1]);
            int op2 = Integer.parseInt(args[2]);
            NumericResponse numericResponse = NumericResponse.builder().answer(op1 + op2).build();
            return CommandResponse.<NumericResponse>builder()
                    .data(numericResponse)
                    .build();
        }
    },
    multiply {
        @Override
        public CommandResponse<NumericResponse> execute(String[] args) {
            int op1 = Integer.parseInt(args[1]);
            int op2 = Integer.parseInt(args[2]);
            NumericResponse numericResponse = NumericResponse.builder().answer(op1 * op2).build();
            return CommandResponse.<NumericResponse>builder()
                    .data(numericResponse)
                    .build();        }
    };
}
