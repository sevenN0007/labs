package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        } else {

            // A regular expression pattern
            Pattern pattern = Pattern.compile("//(\\[.*?\\])\\\\n(.*)");
            Matcher matcher = pattern.matcher(numbers);

            if (matcher.find()) {
                String delimiter = Pattern.quote(matcher.group(1).replaceAll("[\\[\\]]", ""));
                String[] numArray = matcher.group(2).split(delimiter + "|,|\\\\n");

                int sum = 0;
                List negativeNumbers = new ArrayList();

                for (String num : numArray) {
                    try {
                        int currentNumber = Integer.parseInt(num.trim());

                        if (currentNumber < 0) {
                            negativeNumbers.add(currentNumber);
                        } else if (currentNumber <= 1000) {
                            sum += currentNumber;
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalStateException("Please enter valid numbers.");
                    }
                }

                if (!negativeNumbers.isEmpty()) {
                    throw new IllegalStateException("Negatives not allowed: " + negativeNumbers);
                }

                return sum;
            } else {
                // No custom delimiter found, use delimiters (, and \n)
                String[] numArray = numbers.split(",|\\\\n");

                int sum = 0;
                List negativeNumbers = new ArrayList();

                for (String num : numArray) {
                    try {
                        int currentNumber = Integer.parseInt(num.trim());

                        if (currentNumber < 0) {
                            negativeNumbers.add(currentNumber);
                        } else if (currentNumber <= 1000) {
                            sum += currentNumber;
                        }
                    } catch (NumberFormatException e) {
                        throw new IllegalStateException("Please enter valid numbers.");
                    }
                }

                if (!negativeNumbers.isEmpty()) {
                    throw new IllegalStateException("Negatives not allowed: " + negativeNumbers);
                }

                return sum;
            }
        }
    }
}