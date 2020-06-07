package me.danielhoyos.cybersolutions;


import me.danielhoyos.cybersolutions.utils.NumberUtils;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        long startTime = System.currentTimeMillis();
        int digitSize = validateAndReturnInput();
        printPalindrome(digitSize);
        System.out.printf("Time spent: %d ms\n", System.currentTimeMillis() - startTime);
    }

    /**
     * It captures the input from the keyboard and validates the rules.
     * It will only return an integer number between 2 and 15.
     * If the input does not pass the validation, it will inform the user and request it one more time.
     *
     * @return digitSize
     */
    private static int validateAndReturnInput() {
        Scanner scanner = new Scanner(System.in);

        int digitSize;
        boolean validInput = false;
        do {
            System.out.print("Please enter an integer value between 2 and 15: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\"%s\" is NOT an Integer.\n", input);
                System.out.print("Please enter an integer value between 2 and 15: ");
            }
            digitSize = scanner.nextInt();
            if (2 > digitSize || digitSize > 15) {
                System.out.printf("\"%d\" is outside the valid range.\n", digitSize);
            } else {
                validInput = true;
            }

        } while (!validInput);

        return digitSize;
    }

    /**
     * In order to print all the palindromes in a range, it is only necessary to create all the numbers in the
     * lower half of the range and append their corresponding mirrored number.
     * There are two cases, one for even number of digits and other for an odd number of digits.
     *
     * @param digitSize
     */
    private static void printPalindrome(int digitSize) {

        System.out.printf("Range %d-%d\n", NumberUtils.getLowerRangeLimit(digitSize), NumberUtils.getUpperRangeLimit(digitSize));
        System.out.printf("Possible palindrome for %d digits\n", digitSize);

        long lowerRange = NumberUtils.getLowerRangeLimit(digitSize / 2);
        long upperHalfRange = NumberUtils.getUpperRangeLimit(digitSize / 2);

        if(digitSize % 2 == 0) {
            printEvenSizedPalindrome(lowerRange, upperHalfRange);
        } else {
            printOddSizedPalindrome(lowerRange, upperHalfRange);
        }
    }

    /**
     * For an even number of digits, it is only necessary to create all the numbers in the
     * lower half of the range and append their corresponding mirrored number. (xy + yx)
     *
     * @param lowerRange
     * @param upperHalfRange
     */
    private static void printEvenSizedPalindrome(long lowerRange, long upperHalfRange) {
        long count = 0;
        for(long i = lowerRange; i <= upperHalfRange; i++){
            StringBuilder firstHalf = new StringBuilder(String.valueOf(i));
            StringBuilder secondHalf = new StringBuilder(String.valueOf(i)).reverse();

            System.out.println(firstHalf.append(secondHalf).toString());
            count++;
        }
        System.out.printf("Possible palindrome - %d \n", count);
    }

    /**
     * For an odd number of digits, it is necessary to create all the numbers in the
     * lower half of the range, append a number between 0 and 9, and append their corresponding mirrored number.
     * So it will print 10 times more numbers than the even method. (xy + n + yx)
     *
     * @param lowerRange
     * @param upperHalfRange
     */
    private static void printOddSizedPalindrome(long lowerRange, long upperHalfRange) {
        long count = 0;
        for(long i = lowerRange; i <= upperHalfRange; i++){
            StringBuilder firstHalf = new StringBuilder(String.valueOf(i));
            StringBuilder secondHalf = new StringBuilder(String.valueOf(i)).reverse();

            for(int j = 0; j < 10; j++){
                StringBuilder sb = new StringBuilder();
                System.out.println(sb.append(firstHalf).append(j).append(secondHalf).toString());
                count++;
            }
        }
        System.out.printf("Possible palindrome - %d \n", count);
    }

}
