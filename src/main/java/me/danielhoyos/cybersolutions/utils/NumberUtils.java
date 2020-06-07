package me.danielhoyos.cybersolutions.utils;

public class NumberUtils {

    public static long getLowerRangeLimit(int digitSize) {
        return (long) Math.pow(10, digitSize - 1);
    }

    public static long getUpperRangeLimit(int digitSize) {
        return (long) Math.pow(10, digitSize) - 1;
    }

}
