package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        } else {

            // A regular expression pattern
            Pattern pattern = Pattern.compile("//([^\\\\n]+)\\\\n(.*)");
            Matcher matcher = pattern.matcher(numbers);

            if (matcher.find()) {
                String delimiter = Pattern.quote(matcher.group(1));
                String[] numArray = matcher.group(2).split(delimiter + "|,|\\\\n");

                int sum = 0;
                for (String num : numArray) {
                    try {
                        int currentNumber = Integer.parseInt(num.trim());
                        sum += currentNumber;
                    } catch (NumberFormatException e) {
                        throw new IllegalStateException("Please enter valid numbers.");
                    }
                }
                return sum;
            } else {
                // No custom delimiter found, use delimiters (, and \n)
                String[] numArray = numbers.split("|,|\\\\n");

                int sum = 0;
                for (String num : numArray) {
                    try {
                        int currentNumber = Integer.parseInt(num.trim());
                        sum += currentNumber;
                    } catch (NumberFormatException e) {
                        throw new IllegalStateException("Please enter valid numbers.");
                    }
                }
                return sum;
            }
        }
    }
}



