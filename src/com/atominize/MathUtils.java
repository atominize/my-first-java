package com.atominize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This class is for mathematic methods such binomial expansion, simultaneous equations etc
public class MathUtils {
//    public MathUtils() {}


    // Todo: combination, permutation, gamma and beta functions
    public static int factorial(int number) {
        // Todo: write code for finding factorial of numbers
        return 0;
    }

    /*
        use binomial theorem to expand it
     */
    public static String expand(String expression, int power) {
        // Todo: write code for binomial theorem
        return null;
    }

    public static int[] endSimplification(int[] prev_fraction) {
        int[] current_fraction = simplifyFraction(prev_fraction[0], prev_fraction[1]);
        while (!Arrays.equals(prev_fraction, current_fraction)) {
            prev_fraction = current_fraction;
            current_fraction = simplifyFraction(current_fraction[0], current_fraction[1] );
        }
        return prev_fraction;
    }

    private static int[] simplifyFraction(int numerator, int denominator) {
        List<Integer> numerator_factors = getFactors(numerator);
        List<Integer> denominator_factors = getFactors(denominator);
        for (int num_factor: numerator_factors) {
            for (int den_factor: denominator_factors) {
                if (num_factor != 1 & num_factor == den_factor) {
                    numerator /= num_factor;
                    denominator /= num_factor;
                    return new int[] { numerator, denominator };
                }
            }
        }
        return new int[] { numerator, denominator };
    }

    // Todo: gcd of numbers

    public static int getGCD(int first_number, int second_number) {
        int min = Math.min(first_number, second_number);
        int max = Math.max(first_number, second_number);
        List<Integer> min_factors = getFactors(min);
        List<Integer> max_factors = getFactors(max);
        int[] min_array = listToArray(min_factors);
        Arrays.sort(min_array);
        int gcd = 1;
        for (int i = min_array.length - 1; i >= 0; i--) {
            for (int item: max_factors) {
                if (min_array[i] == item) {
                    return item;
                }
            }
        }
        return gcd;
    }

    private static int[] listToArray(List<Integer> integerList) {
        int[] ints = new int[integerList.size()];
        for (int i = 0; i < integerList.size(); i++) {
            ints[i] = integerList.get(i);
        }
        return ints;
    }

    public static int getLCM(int first_number, int second_number) {
        int max = Math.max(first_number, second_number);
        int min = Math.min(first_number, second_number);
        int remainder;
        int lcm = max;
        for (int i = 1; i < min + 1; i++) {
            lcm = max * i;
            remainder = lcm % min;
            if (remainder == 0) break;
        }
        return lcm;
    }

    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        if (number == 0) {
//            System.out.println("Wrong number");
            factors.add(0);
            return factors;
        }
        if (number <= -1) {
            number *= -1;
        }
        factors.add(1);
        if (number == 1) {
            return factors;
        }
        factors.add(number);
        int start, end;
        start = 1;
        end = number;
        while (getFactor(start, end, number) != 0) {
            int next_factor = getFactor(start, end, number);
            int next_factor_comp = number / next_factor;
            factors.add(next_factor);
            if (next_factor == next_factor_comp) {
//                System.out.println(next_factor);
                break;
            }
            factors.add(next_factor_comp);
            start = next_factor;
            end = next_factor_comp;
        }

        return factors;
    }

    private static int getFactor(int start, int end, int number) {
        int factor = 0;
        for (int i = start + 1; i < end; i++) {
            int remainder = number % i;
            if (remainder == 0) {
                factor = i;
                break;
            }
        }
        return factor;
    }
}
