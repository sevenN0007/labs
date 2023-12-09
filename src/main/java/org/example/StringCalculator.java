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
                String rawDelimiters = matcher.group(1);
                List<String> delimiters = extractDelimiters(rawDelimiters);

                // a regex pattern for multiple delimiters
                String delimiterRegex = delimiters.stream()
                        .map(delimiter -> Pattern.quote(delimiter))
                        .reduce((d1, d2) -> d1 + "|" + d2)
                        .orElseThrow();

                String[] numArray = matcher.group(2).split(delimiterRegex + "|,|\\\\n");

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
                // No custom delimiter found, use default delimiters (, and \n)
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

    // method to extract delimiters from the raw string
    private List<String> extractDelimiters(String rawDelimiters) {
        List delimiters = new ArrayList();
        Matcher delimiterMatcher = Pattern.compile("\\[(.*?)\\]").matcher(rawDelimiters);

        while (delimiterMatcher.find()) {
            delimiters.add(delimiterMatcher.group(1));
        }

        return delimiters;
    }
}
