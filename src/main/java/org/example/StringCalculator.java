package org.example;

public class StringCalculator {
    public int add(String numbers) throws NumberFormatException {
        if (numbers.isEmpty()) {
            return 0;
        } else {
            // Split the input string into an array of numbers
            String[] numArray = numbers.split(",");

            int sum = 0;
            for (String num : numArray) {
                try {
                    int currentNumber = Integer.parseInt(num);
                    sum += currentNumber;
                } catch (NumberFormatException e) {
                    throw new NumberFormatException("Please enter valid numbers.");
                }
            }

            return sum;
        }
    }
}

