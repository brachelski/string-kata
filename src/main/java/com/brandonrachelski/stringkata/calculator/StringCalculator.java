package com.brandonrachelski.stringkata.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    public int add(String text) throws IllegalArgumentException {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        List<Integer> negatives = new ArrayList<>();
        char customDelimiter = getCustomDelimiter(text.split("\n")[0]);

        String[] nums = (customDelimiter == ',')
                ? text.split(",|\n")
                : text.split("\n|" + customDelimiter);

        int result = 0;
        for (String num : nums) {
            if (num.isEmpty()) {
                continue;
            }
            num = num.trim();
            int number = Integer.parseInt(num);
            if (number > 1000) {
                continue;
            }
            if (number < 0) {
                negatives.add(number);
            } else {
                result += number;
            }
        }

        if (!negatives.isEmpty()) {
            String negativeNumbers = (negatives.size() > 1)
                    ? ": " + negatives.stream().map(Object::toString).collect(Collectors.toList())
                    : "";
            throw new IllegalArgumentException("Negatives not allowed" + negativeNumbers);
        }
        return result;
    }

    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private char getCustomDelimiter(String line) {
        if (line == null || line.isEmpty()) {
            return ',';
        }
        if (isNumeric(line)) {
            return ',';
        }
        if (line.length() == 1) {
            return line.charAt(0);
        }
        return ',';
    }
}
