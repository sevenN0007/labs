package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter numbers separated by commas: ");
        String text = scanner.nextLine();

        StringCalculator stringCalculator = new StringCalculator();

        try {
            int result = stringCalculator.add(text);
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}