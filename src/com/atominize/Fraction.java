package com.atominize;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This class is for displaying and manipulating fractions
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Todo: learn to override operations

    public void display() {
        int[] factors = endSimplification(new int[] { numerator, denominator });
        String fraction = String.valueOf(factors[0]) + "/" + String.valueOf(factors[1]);
        if (factors[1] == 1) {
            fraction = String.valueOf(factors[0]);
        }
        System.out.println(fraction);
    }

    public static Fraction add(Fraction first_fraction, Fraction second_fraction) {
        int denominator = first_fraction.denominator * second_fraction.denominator;
        int numerator = (denominator / first_fraction.denominator) * first_fraction.numerator
                + (denominator / second_fraction.denominator) * second_fraction.numerator;
        int[] factors = endSimplification(new int[] { numerator, denominator });
        return new Fraction(factors[0], factors[1]);
    }

    private static int[] endSimplification(int[] prev_fraction) {
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

    // Todo: gcd and lcm functions
    public static List<Integer> getFactors(int number) {
        List<Integer> factors = new ArrayList<>();
        if (number < 1) {
            System.out.println("Wrong number");
            factors.add(0);
            return factors;
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
