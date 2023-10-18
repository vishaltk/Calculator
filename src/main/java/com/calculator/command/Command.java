package com.calculator.command;

import com.calculator.dto.CommandResponse;

public interface Command {
    CommandResponse execute(String[] args);
}
