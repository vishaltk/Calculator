package com.calculator.command;

import com.calculator.dto.CommandResponse;
import com.calculator.dto.ErrorCode;
import com.calculator.dto.ErrorInfo;
import com.calculator.dto.NumericResponse;

public enum CommandImpl implements Command {
    add {
        @Override
        public CommandResponse<NumericResponse> execute(String[] args) {
            return executeOperation(args, (op1, op2) -> op1 + op2);
        }
    },
    subtract {
        @Override
        public CommandResponse<NumericResponse> execute(String[] args) {
            return executeOperation(args, (op1, op2) -> op1 - op2);
        }
    },
    multiply {
        @Override
        public CommandResponse<NumericResponse> execute(String[] args) {
            return executeOperation(args, (op1, op2) -> op1 * op2);
        }
    },
    divide {
        @Override
        public CommandResponse<NumericResponse> execute(String[] args) {
                int op1 = Integer.parseInt(args[1]);
                int op2 = Integer.parseInt(args[2]);

                if (op2 == 0) {
                    return CommandResponse.<NumericResponse>builder()
                            .errorInfo(ErrorInfo.builder()
                                    .message("division by zero is invalid")
                                    .errorCode(ErrorCode.INVALID_INPUT)
                                    .build())
                            .build();
                }

                NumericResponse numericResponse = NumericResponse.builder().answer(op1 / op2).build();
                return CommandResponse.<NumericResponse>builder()
                        .data(numericResponse)
                        .build();
        }
    };

    private static CommandResponse<NumericResponse> executeOperation(String[] args, NumericOperation operation) {
        if (args.length < 3) {
            return CommandResponse.<NumericResponse>builder()
                    .errorInfo(ErrorInfo.builder()
                            .message("Insufficient arguments")
                            .errorCode(ErrorCode.INVALID_INPUT)
                            .build())
                    .build();
        }
        try {
            int op1 = Integer.parseInt(args[1]);
            int op2 = Integer.parseInt(args[2]);
            NumericResponse numericResponse = NumericResponse.builder().answer(operation.apply(op1, op2)).build();
            return CommandResponse.<NumericResponse>builder()
                    .data(numericResponse)
                    .build();
        } catch (NumberFormatException | ArithmeticException e) {
            return CommandResponse.<NumericResponse>builder()
                    .errorInfo(ErrorInfo.builder()
                            .message("Invalid inputs")
                            .errorCode(ErrorCode.INVALID_INPUT)
                            .build())
                    .build();
        }
    }

    @FunctionalInterface
    private interface NumericOperation {
        int apply(int op1, int op2);
    }
}
