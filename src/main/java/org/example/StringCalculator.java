package org.example;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            // Split the input string into an array of numbers using commas and newline characters
            String[] numArray = numbers.split(",");

            int sum = 0;
            for (String num : numArray) {
                    try {
                        int currentNumber = Integer.parseInt(num.trim());
                        sum += currentNumber;
                    } catch (NumberFormatException e) {
                        throw new NumberFormatException("Please enter valid numbers.");
                    }

            }

            return sum;
        }
    }
}

