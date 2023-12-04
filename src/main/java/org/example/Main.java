package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter numbers separated by commas: ");
            String input = reader.readLine();

            // Replace line characters
            input = input.replaceAll("\\\\n", ",");

            StringCalculator calculator = new StringCalculator();
            int result = calculator.add(input);
            System.out.println("Result: " + result);

        } catch (IOException | NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}


