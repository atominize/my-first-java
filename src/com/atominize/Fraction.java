package com.atominize;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This class is for displaying and manipulating fractions
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {}

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Todo: work on, convert fractions to double and vice versa

    public void display() {
        int[] factors = MathUtils.endSimplification(new int[] { numerator, denominator });
        String fraction = String.valueOf(factors[0]) + "/" + String.valueOf(factors[1]);
        if (factors[1] == 1 || factors[0] == 0) {
            fraction = String.valueOf(factors[0]);
        }
        System.out.println(fraction);
    }

    public static Fraction add(Fraction first_fraction, Fraction second_fraction) {
        int denominator = first_fraction.denominator * second_fraction.denominator;
        int numerator = (denominator / first_fraction.denominator) * first_fraction.numerator
                + (denominator / second_fraction.denominator) * second_fraction.numerator;
        int[] factors = MathUtils.endSimplification(new int[] { numerator, denominator });
        return new Fraction(factors[0], factors[1]);
    }

    public static Fraction subtract(Fraction first_fraction, Fraction second_fraction) {
        if (first_fraction.equals(second_fraction)) {
            return new Fraction(0, 1);
        }
        second_fraction.numerator = -1 * second_fraction.numerator;
        return add(first_fraction, second_fraction);
    }

    public static Fraction multiply(Fraction first_fraction, Fraction second_fraction) {
        int numerator = first_fraction.numerator * second_fraction.numerator;
        int denominator = first_fraction.denominator * second_fraction.denominator;
        int[] factors = MathUtils.endSimplification(new int[] { numerator, denominator});
        return new Fraction(factors[0], factors[1]);
    }

    public static Fraction reciprocal(Fraction fraction) {
        return new Fraction(fraction.denominator, fraction.numerator);
    }

    public static Fraction divide(Fraction first_fraction, Fraction second_fraction) {
        return multiply(first_fraction, reciprocal(second_fraction));
    }

    // Todo: work on displaying the solution and show work and fix bugs such as division by zero
}
