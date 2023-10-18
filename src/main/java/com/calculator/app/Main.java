package com.calculator.app;

import com.calculator.command.Command;
import com.calculator.command.CommandImpl;
import com.calculator.dto.CommandResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Sample commands");
        System.out.println("add 1 2\nmultiply 2 4");
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        Command command;
        while (shouldContinue) {
            String input = scanner.nextLine();
            if("".equals(input)) {
                shouldContinue = false;
            } else {
                command = CommandImpl.valueOf(input.split(" ")[0]);
                CommandResponse commandResponse = command.execute(input.split(" "));
                System.out.println(commandResponse.getData());
            }
        }
    }
}