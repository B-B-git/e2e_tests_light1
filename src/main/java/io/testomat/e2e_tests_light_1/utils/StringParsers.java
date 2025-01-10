package io.testomat.e2e_tests_light_1.utils;

public class StringParsers {

    public static Integer parseIntegerFromString(String countOfTests) {
        String digitText = countOfTests.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);
    }

    public static Double parseDoubleFromString(String targetText) {
        String doubleText = targetText.replaceAll("\\D+", "");
        return Double.parseDouble(doubleText);
    }
}
