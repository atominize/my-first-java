package com.atominize;


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

    // Todo: factors, gcd and lcd functions
}
