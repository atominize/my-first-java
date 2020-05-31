package com.atominize;


import java.util.ArrayList;
import java.util.List;

// This class is for displaying and manipulating fractions
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    public void display() {
        int remainder = numerator % denominator;
        String fraction = String.valueOf(numerator) + "/" + String.valueOf(denominator);
        if (remainder == 0) {
            fraction = String.valueOf(numerator / denominator);
        }
        System.out.println(fraction);
    }

    public static Fraction add(Fraction first_fraction, Fraction second_fraction) {
        int denominator = first_fraction.denominator * second_fraction.denominator;
        int numerator = (denominator / first_fraction.denominator) * first_fraction.numerator
                + (denominator / second_fraction.denominator) * second_fraction.numerator;
        return new Fraction(numerator, denominator);
    }

    // Todo: gcd and lcd functions
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
                System.out.println(next_factor);
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
